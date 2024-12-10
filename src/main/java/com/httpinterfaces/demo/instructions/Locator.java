package com.httpinterfaces.demo.instructions;

import lombok.Data;

@Data
public class Locator {
    private Metadata metadata;

    @Data
    public static class Metadata {
        private String system;
        private boolean isInternal;
    }
}
