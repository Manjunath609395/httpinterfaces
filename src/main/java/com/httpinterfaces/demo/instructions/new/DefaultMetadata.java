package com.httpinterfaces.demo.instructions.

import java.util.Map;

public class DefaultMetadata implements Metadata {
    private String system;
    private boolean isInternal;

    @Override
    public void populate(Map<String, Object> metadataMap) {
        this.system = (String) metadataMap.get("system");
        this.isInternal = Boolean.parseBoolean(metadataMap.get("isInternal").toString());
    }

    @Override
    public String getSystem() {
        return system;
    }

    @Override
    public void setSystem(String system) {
        this.system = system;
    }

    @Override
    public boolean isInternal() {
        return isInternal;
    }

    @Override
    public void setInternal(boolean internal) {
        this.isInternal = internal;
    }

    @Override
    public String toString() {
        return "DefaultMetadata{" +
                "system='" + system + '\'' +
                ", isInternal=" + isInternal +
                '}';
    }
}
