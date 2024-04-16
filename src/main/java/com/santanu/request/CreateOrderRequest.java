package com.santanu.request;

import com.santanu.model.Address;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
