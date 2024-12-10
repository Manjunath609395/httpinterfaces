package com.httpinterfaces.demo.instructions;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DecomposeInstructionsProviderImpl implements DecomposeInstructionsProvider {

    private final LocatorStrategy configLocatorStrategy;
    private final LocatorStrategy apiLocatorStrategy;

    public DecomposeInstructionsProviderImpl(ConfigLocatorStrategy configLocatorStrategy,
                                             ApiLocatorStrategy apiLocatorStrategy) {
        this.configLocatorStrategy = configLocatorStrategy;
        this.apiLocatorStrategy = apiLocatorStrategy;
    }

    @Override
    public List<Instruction> decompose(PaymentCDMRequest cdmRequest) {
        List<Instruction> instructions = new ArrayList<>();

        cdmRequest.getDecomposeTransactions().forEach(transaction -> {
            Locator resolvedLocator;

            // Choose strategy based on locator metadata
            if (transaction.getLocator().getMetadata().getIsInternal()) {
                resolvedLocator = configLocatorStrategy.resolveLocator(transaction.getLocator());
            } else {
                resolvedLocator = apiLocatorStrategy.resolveLocator(transaction.getLocator());
            }

            // Create and add instruction
            instructions.add(createInstruction(transaction, resolvedLocator));
        });

        return instructions;
    }

    private Instruction createInstruction(Transaction transaction, Locator resolvedLocator) {
        return Instruction.builder()
                .debitAccount(transaction.getDebitAccount())
                .creditAccount(transaction.getCreditAccount())
                .postingType(transaction.getPostingType())
                .resolvedLocator(resolvedLocator)
                .build();
    }
}
