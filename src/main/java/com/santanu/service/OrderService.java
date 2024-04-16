package com.santanu.service;

import com.santanu.Exception.CartException;
import com.santanu.Exception.OrderException;
import com.santanu.Exception.RestaurantException;
import com.santanu.Exception.UserException;
import com.santanu.model.Order;
import com.santanu.model.PaymentResponse;
import com.santanu.model.User;
import com.santanu.request.CreateOrderRequest;
import com.stripe.exception.StripeException;

import java.util.List;

public interface OrderService {
    public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;

    public Order updateOrder(Long orderId, String orderStatus) throws OrderException;

    public void cancelOrder(Long orderId) throws OrderException;

    public List<Order> getUserOrders(Long userId) throws OrderException;

    public List<Order> getOrdersOfRestaurant(Long restaurantId, String orderStatus) throws OrderException, RestaurantException;
}
