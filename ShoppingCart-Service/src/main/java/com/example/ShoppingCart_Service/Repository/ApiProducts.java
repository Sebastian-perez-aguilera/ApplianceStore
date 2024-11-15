package com.example.ShoppingCart_Service.Repository;


import com.example.ShoppingCart_Service.DTOs.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "Products-Service")
public interface ApiProducts {

    @GetMapping("products/getproductsbyid/{id_shoppingCart}")
   List<ProductsDTO> getproductsbyid (@PathVariable ("id_shoppingCart") Long id_shoppingCart);

    @DeleteMapping("products/DeleteProduct/{code}")
public void deletebyproductid(@PathVariable ("code") Long code);

}
