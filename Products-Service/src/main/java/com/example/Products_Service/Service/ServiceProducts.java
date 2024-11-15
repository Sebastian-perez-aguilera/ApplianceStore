package com.example.Products_Service.Service;

import com.example.Products_Service.Model.Products;
import com.example.Products_Service.Repository.IRepositoryProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProducts implements  IServiceProducts{

    @Autowired
    IRepositoryProducts repoprodu;

    @Override
    public List<Products> getProductsByIdShoppingCart(Long id_shoppingCart) {
        return repoprodu.getProductsByCart(id_shoppingCart);
    }

    @Override
    public List<Products> GetallProducts() {
        return repoprodu.findAll();

    }

    @Override
    public void saveProducts(Products product) {
      repoprodu.save(product);

    }

    @Override
    public void deleteProducts(Long code) {
        repoprodu.deleteById(code);
    }

    @Override
    public Products findProduct(Long code) {
        return repoprodu.findById(code).orElse(null);
    }
}
