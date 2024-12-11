package com.httpinterfaces.demo.instructions.

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DecomposeTransactionImpl implements DecomposeTransaction {

    private final ApplicationContext applicationContext;

    public DecomposeTransactionImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public List<Instruction> decompose(CDMPaymentRequest cdmPaymentRequest) {
        List<Instruction> instructions = new ArrayList<>();

        for (DecomposeTransactionConfig config : cdmPaymentRequest.getDecomposeTransactions()) {
            // Determine which locator to use
            String locatorBeanName = determineLocatorBeanName(config.getLocator());
            Locator locator = (Locator) applicationContext.getBean(locatorBeanName);

            // Populate metadata
            Metadata metadata = new DefaultMetadata();
            metadata.populate((Map<String, Object>) config.getLocator().get("metadata"));
            locator.setMetadata(metadata);

            System.out.println("Resolved Locator: " + locator);

            // Example: Build instructions
            Instruction instruction = new Instruction();
            instruction.setDebitAccount(config.getDebitAccount());
            instruction.setCreditAccount(config.getCreditAccount());
            instruction.setPostingType(config.getPostingType());
            instructions.add(instruction);
        }

        return instructions;
    }

    private String determineLocatorBeanName(Map<String, Object> locatorConfig) {
        String system = (String) locatorConfig.get("metadata").get("system");
        if ("a".equals(system)) {
            return "defaultLocator";
        } else if ("b".equals(system)) {
            return "customLocator";
        }
        throw new IllegalArgumentException("Unknown system: " + system);
    }
}
