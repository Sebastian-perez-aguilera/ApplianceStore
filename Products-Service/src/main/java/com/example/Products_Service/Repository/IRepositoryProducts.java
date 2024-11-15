package com.example.Products_Service.Repository;

import com.example.Products_Service.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryProducts extends JpaRepository<Products, Long> {

    @Query("SELECT p FROM Products p WHERE p.id_shoppingCart = :id_shoppingCart")
    List<Products> getProductsByCart(Long id_shoppingCart);


}
