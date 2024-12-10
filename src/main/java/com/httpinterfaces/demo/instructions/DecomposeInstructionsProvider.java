package com.httpinterfaces.demo.instructions;

import java.util.List;

public interface DecomposeInstructionsProvider {
    List<Instruction> decompose(PaymentCDMRequest cdmRequest);
}
