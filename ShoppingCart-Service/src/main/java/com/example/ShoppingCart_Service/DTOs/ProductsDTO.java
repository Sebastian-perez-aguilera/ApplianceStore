package com.example.ShoppingCart_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    private Long code;
    private String name;
    private String brand;
    private Double individualPrice;
    private Long  id_shoppingCart;

}
