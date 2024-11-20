package com.httpinterfaces.demo.finals;

@Service
public class ApiService {

    private final RestClientHelper restClientHelper;
    private final MyApiClient myApiClient;

    public ApiService(RestClientHelper restClientHelper, MyApiClient myApiClient) {
        this.restClientHelper = restClientHelper;
        this.myApiClient = myApiClient;
    }

    public String getResource(String id) {
        return restClientHelper.executeWithRetry(() -> myApiClient.getResource(id).getBody());
    }
}
