package com.santanu.request;

import lombok.Data;

@Data
public class CreateIngredientCategoryRequest {
    private Long restaurantId;
    private String name;
}

