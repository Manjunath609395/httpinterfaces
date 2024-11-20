package com.httpinterfaces.demo.finals;

@Configuration
public class RestClientConfig {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5)) // Connection timeout
            .build();
    }

    @Bean
    public RestClient restClient(HttpClient httpClient) {
        return RestClient.builder()
            .httpClient(httpClient)
            .defaultRequestModifier(request -> {
                request.timeout(Duration.ofSeconds(10)); // Read timeout
                request.headers().add("Accept", "application/json");
            })
            .build();
    }
}
