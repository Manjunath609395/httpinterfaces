package com.httpinterfaces.demo.instructions;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.model.CDMPaymentRequest;

public interface TransformRequest {
    CDMPaymentRequest transform(PaymentRequest paymentRequest);
}
