package com.httpinterfaces.demo.instructions.

import org.springframework.stereotype.Component;

@Component("defaultLocator")
public class DefaultLocator implements Locator {
    private Metadata metadata;

    @Override
    public Metadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "DefaultLocator{" +
                "metadata=" + metadata +
                '}';
    }
}
