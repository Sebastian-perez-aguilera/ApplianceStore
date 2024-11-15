package com.example.ShoppingCart_Service.Repository;

import com.example.ShoppingCart_Service.Model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryShoppingCart extends JpaRepository<ShoppingCart,Long > {

    @Query ("SELECT s FROM ShoppingCart s WHERE s.id_sells = :id_sells")
    List<ShoppingCart> getShoppingCartByIdSells (Long id_sells);



}
