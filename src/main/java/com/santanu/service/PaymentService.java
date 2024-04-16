package com.santanu.service;

import com.santanu.model.Order;
import com.santanu.model.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}
