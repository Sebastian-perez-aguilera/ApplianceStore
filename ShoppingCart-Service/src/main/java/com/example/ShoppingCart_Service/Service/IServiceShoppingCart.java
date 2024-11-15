package com.example.ShoppingCart_Service.Service;

import com.example.ShoppingCart_Service.DTOs.ShoppingCartDTO;
import com.example.ShoppingCart_Service.Model.ShoppingCart;

import java.util.List;

public interface IServiceShoppingCart {

    public ShoppingCartDTO getproductsbyid (Long id_shoppingCart);

    public void SaveShoppingCart (ShoppingCart shopcart);

    public List<ShoppingCart> GetShoppingcartbyid (Long id_sells);

    public void deleteProductBycode (Long code);
}
