package com.httpinterfaces.demo.finals;

@Component
public class RestClientHelper {

    private final RetryTemplate retryTemplate;

    public RestClientHelper() {
        this.retryTemplate = RetryTemplate.builder()
            .maxAttempts(3)
            .fixedBackoff(2000) // 2 seconds between retries
            .retryOn(HttpStatusCodeException.class) // Retry for HTTP exceptions
            .retryOn(ReadTimeoutException.class)    // Retry for timeouts
            .build();
    }

    public <T> T executeWithRetry(Supplier<T> action) {
        try {
            return retryTemplate.execute(context -> action.get());
        } catch (HttpStatusCodeException | ReadTimeoutException ex) {
            throw new CustomApiException("ERR_RETRY_EXCEEDED", 500, "Retries exhausted", ex.getResponseBodyAsString());
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error during API execution", ex);
        }
    }
}
