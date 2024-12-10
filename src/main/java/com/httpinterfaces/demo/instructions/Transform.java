package com.httpinterfaces.demo.instructions;

import com.example.payment.marker.MarkerInterface;
import com.example.payment.model.CDMPaymentRequest;

public interface Transform<T extends MarkerInterface> {
    CDMPaymentRequest transform(T request);
}
