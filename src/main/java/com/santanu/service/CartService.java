package com.santanu.service;

import com.santanu.Exception.CartException;
import com.santanu.Exception.CartItemException;
import com.santanu.Exception.FoodException;
import com.santanu.Exception.UserException;
import com.santanu.model.Cart;
import com.santanu.model.CartItem;
import com.santanu.request.AddCartItemRequest;

public interface CartService {
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws CartItemException;

    public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

    public Long calculateCartTotals(Cart cart) throws UserException;

    public Cart findCartById(Long id) throws CartException;

    public Cart findCartByUserId(Long userId) throws CartException, UserException;

    public Cart clearCart(Long userId) throws CartException, UserException;
}
