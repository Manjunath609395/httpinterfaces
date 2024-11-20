package com.httpinterfaces.demo.users;

@Configuration
public class RestClientConfig {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5)) // Connection timeout
            .executor(Executors.newFixedThreadPool(10)) // Optional: thread pool
            .build();
    }

    @Bean
    public RestClient restClient(HttpClient httpClient) {
        return RestClient.builder()
            .httpClient(httpClient)
            .defaultRequestModifier(request -> {
                // Set custom timeouts per request
                request.timeout(Duration.ofSeconds(10)); // Read timeout
                request.headers().add("Accept", "application/json");
            })
            .build();
    }
}
