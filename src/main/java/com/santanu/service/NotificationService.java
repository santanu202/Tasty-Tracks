package com.santanu.service;

import com.santanu.model.Notification;
import com.santanu.model.Order;
import com.santanu.model.Restaurant;
import com.santanu.model.User;

import java.util.List;

public interface NotificationService {
    public Notification sendOrderStatusNotification(Order order);

    public void sendRestaurantNotification(Restaurant restaurant, String message);

    public void sendPromotionalNotification(User user, String message);

    public List<Notification> findUsersNotification(Long userId);
}
