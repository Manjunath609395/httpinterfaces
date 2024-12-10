package com.httpinterfaces.demo.instructions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Instruction {
    private String debitAccount;
    private String creditAccount;
    private String postingType;
    private Locator resolvedLocator;
}
