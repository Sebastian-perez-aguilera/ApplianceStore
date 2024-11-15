package com.example.ShoppingCart_Service.Controller;


import com.example.ShoppingCart_Service.DTOs.ShoppingCartDTO;
import com.example.ShoppingCart_Service.Model.ShoppingCart;
import com.example.ShoppingCart_Service.Service.ServiceShoppingCart;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ShoppingCart")
public class ControllerShoppingCart {

    @Autowired
    ServiceShoppingCart serviCart;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/getProductsById/{id_shoppingCart}")
    public ShoppingCartDTO getProductsByIdCart(@PathVariable Long id_shoppingCart) {
        System.out.println("This is the port: " + serverPort);
        return serviCart.getproductsbyid(id_shoppingCart);
    }
        @GetMapping("/saveShoppingcart")
        public String saveshoppingcart (@RequestBody ShoppingCart shopcart){
     serviCart.SaveShoppingCart(shopcart);

     return "The Shoppingcart is saved and ready to use";
        }

        @GetMapping("/getShoppingcartById/{id_sells}")
    public List<ShoppingCart> getCartByIdSells (@PathVariable Long id_sells){
       return serviCart.GetShoppingcartbyid(id_sells);
        }

        @DeleteMapping("/DeleteProductFromCart/{code}")
    public String deleteproductfromcart (@PathVariable Long code){
        serviCart.deleteProductBycode(code);
        return "The Product has been removed from the shoppingCart list.";
        }
    }

