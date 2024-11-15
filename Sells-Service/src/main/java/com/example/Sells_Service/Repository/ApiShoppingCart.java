package com.example.Sells_Service.Repository;


import com.example.Sells_Service.Dto.DtoShoppingCart;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ShoppingCart-Service")
public interface ApiShoppingCart {

    @GetMapping("/ShoppingCart/getShoppingcartById/{id_sells}")
    List<DtoShoppingCart> dtoshoppingcart (@PathVariable ("id_sells") Long id_sells);

}
