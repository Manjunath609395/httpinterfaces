package com.httpinterfaces.demo.finals;

@Component
public class MyApiClient {

    private final RestClient restClient;

    public MyApiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public ResponseEntity<String> getResource(String id) {
        return restClient.get()
            .uri("https://api.example.com/resource/" + id)
            .retrieve()
            .toEntity(String.class);
    }
}
