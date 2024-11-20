package com.httpinterfaces.demo.finals;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/resource/{id}")
    public ResponseEntity<String> getResource(@PathVariable String id) {
        try {
            String response = apiService.getResource(id);
            return ResponseEntity.ok(response);
        } catch (CustomApiException ex) {
            return ResponseEntity.status(ex.getHttpStatus())
                .body("Error Code: " + ex.getErrorCode() + ", Message: " + ex.getMessage());
        }
    }
}
