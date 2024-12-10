package com.httpinterfaces.demo.instructions;

import com.example.payment.model.CDMPaymentRequest;
import com.example.payment.model.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class TransformImpl implements Transform<PaymentRequest> {

    @Override
    public CDMPaymentRequest transform(PaymentRequest request) {
        // Example transformation logic
        CDMPaymentRequest cdmRequest = new CDMPaymentRequest();
        cdmRequest.setCustomerAccount(request.getSourceAccount());
        cdmRequest.setPaymentType(request.getTransactionType());
        cdmRequest.setPaymentSubType(request.getTransactionSubType());
        cdmRequest.setAmount(request.getAmount());

        // Add additional mapping logic as needed
        return cdmRequest;
    }
}
