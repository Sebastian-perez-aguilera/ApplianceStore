package com.example.Products_Service.Service;

import com.example.Products_Service.Model.Products;

import java.util.List;

public interface IServiceProducts {


    public List<Products> getProductsByIdShoppingCart(Long id_shoppingCart);

    public List<Products> GetallProducts ();

    public void saveProducts(Products product);

    public void deleteProducts(Long code);

    public Products findProduct (Long code);




}
