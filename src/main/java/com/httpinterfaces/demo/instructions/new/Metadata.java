package com.httpinterfaces.demo.instructions.

public interface Metadata {
    void populate(Map<String, Object> metadataMap);

    String getSystem();
    
    void setSystem(String system);

    boolean isInternal();
    
    void setInternal(boolean internal);
}
