package com.httpinterfaces.demo.instructions;

import org.springframework.stereotype.Component;

@Component
public class ConfigLocatorStrategy implements LocatorStrategy {
    @Override
    public Locator resolveLocator(Locator locatorConfig) {
        // Return locator as is, since it's in the config
        return locatorConfig;
    }
}
