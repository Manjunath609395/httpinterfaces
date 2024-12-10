package com.httpinterfaces.demo.instructions;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.model.CDMPaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class TransformRequestImpl implements TransformRequest {

    @Override
    public CDMPaymentRequest transform(PaymentRequest paymentRequest) {
        // Implement logic to map fields from PaymentRequest to CDMPaymentRequest
        return new CDMPaymentRequest(
            paymentRequest.getPaymentType(),
            paymentRequest.getPaymentSubType(),
            paymentRequest.getAmount(),
            paymentRequest.getCustomerDetails()
        );
    }
}
