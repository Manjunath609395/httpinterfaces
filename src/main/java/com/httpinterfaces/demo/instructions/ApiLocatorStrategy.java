package com.httpinterfaces.demo.instructions;

import org.springframework.stereotype.Component;

@Component
public class ApiLocatorStrategy implements LocatorStrategy {
    @Override
    public Locator resolveLocator(Locator locatorConfig) {
        // Make external API call here based on `system` or other fields
        // Example: Fetch from API using `locatorConfig.getMetadata().getSystem()`
        return fetchFromApi(locatorConfig);
    }

    private Locator fetchFromApi(Locator locatorConfig) {
        // Simulate API fetch logic
        return new Locator(); // Replace with actual resolved locator
    }
}
