package com.example.ShoppingCart_Service.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

    Long id_shoppingCart;
    double total_price;
    List<ProductsDTO> produdto;
}
