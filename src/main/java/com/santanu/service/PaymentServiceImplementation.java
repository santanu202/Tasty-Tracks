package com.santanu.service;

import com.santanu.model.Order;
import com.santanu.model.PaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class PaymentServiceImplementation implements PaymentService {
    @Value("${stripe.api.key}")
    private String stripeSecretKey;

    @Value("${openexchangerates.api.key}") // Injecting the API key from application.properties
    private String openExchangeRatesApiKey;

    @Override
    public PaymentResponse generatePaymentLink(Order order) throws StripeException {
        Stripe.apiKey = stripeSecretKey;

        // Convert order amount to INR using Open Exchange Rates API
        double totalAmountInInr = convertToINR(order.getTotalAmount());

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/payment/success/" + order.getId())
                .setCancelUrl("http://localhost:3000/cancel")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("inr")
                                .setUnitAmount((long) totalAmountInInr) // Convert amount to cents
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName("pizza burger")
                                        .build())
                                .build())
                        .build())
                .build();
        Session session = Session.create(params);

        PaymentResponse res = new PaymentResponse();
        res.setPayment_url(session.getUrl());
        return res;
    }

    private double convertToINR(long amount) {
        // Construct the URL for Open Exchange Rates API
        String url = "https://open.er-api.com/v6/latest?app_id=" + openExchangeRatesApiKey + "&symbols=INR";

        // Make a GET request to Open Exchange Rates API
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> result = restTemplate.getForObject(url, Map.class);

        // Parse the response to get the exchange rate
        Map<String, Object> rates = (Map<String, Object>) result.get("rates");
        double exchangeRate = (double) rates.get("INR");

        // Convert the amount to INR
        return amount * exchangeRate;
    }
}


/*
@Service
public class PaymentServiceImplementation implements PaymentService {
    @Value("${stripe.api.key}")
    private String stripeSecretKey;

    @Override
    public PaymentResponse generatePaymentLink(Order order) throws StripeException {
        Stripe.apiKey = stripeSecretKey;
        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/payment/success/" + order.getId())
                .setCancelUrl("http://localhost:3000/cancel")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("inr")
                                .setUnitAmount((long) order.getTotalAmount() * 100) // Specify the order amount in cents
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName("pizza burger")
                                        .build())
                                .build())
                        .build())
                .build();
        Session session = Session.create(params);
//        System.out.println("session _____ " + session);
        PaymentResponse res = new PaymentResponse();
        res.setPayment_url(session.getUrl());
        return res;
    }
}*/
