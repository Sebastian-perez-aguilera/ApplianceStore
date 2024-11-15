package com.example.ShoppingCart_Service.Service;

import com.example.ShoppingCart_Service.DTOs.ProductsDTO;
import com.example.ShoppingCart_Service.DTOs.ShoppingCartDTO;
import com.example.ShoppingCart_Service.Model.ShoppingCart;
import com.example.ShoppingCart_Service.Repository.ApiProducts;
import com.example.ShoppingCart_Service.Repository.IRepositoryShoppingCart;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceShoppingCart implements IServiceShoppingCart{

    @Autowired
    ApiProducts apiProducts;

    @Autowired
    IRepositoryShoppingCart repocart;


    @Override
    @CircuitBreaker(name="Products-Service", fallbackMethod = "fallbackgetproductsbyid")
    @Retry(name="Products-Service")
    public ShoppingCartDTO getproductsbyid(Long id_shoppingCart) {

        double totalprice = 0;

        ShoppingCart shoppingCart = repocart.findById(id_shoppingCart).orElse(null);
        List<ProductsDTO> productsDTOS = apiProducts.getproductsbyid(id_shoppingCart);

        for (ProductsDTO  product: productsDTOS ){
            totalprice += product.getIndividualPrice();
        };

        assert shoppingCart != null;
        shoppingCart.setTotal_price(totalprice);

        repocart.save(shoppingCart);


        return new ShoppingCartDTO(shoppingCart.getId_shoppingCart(), shoppingCart.getTotal_price(), productsDTOS);
    }

    public ShoppingCartDTO fallbackgetproductsbyid (Throwable throwable){

        return new ShoppingCartDTO(99999999999999l, 00000000000, null);
    }

    public void create(){
        throw new IllegalArgumentException("Test Resiliance and Circuit Breaker");
    }

    @Override
    public void SaveShoppingCart(ShoppingCart shopcart) {
       repocart.save(shopcart);
    }

    @Override
    public List<ShoppingCart> GetShoppingcartbyid(Long id_sells) {
     return repocart.getShoppingCartByIdSells(id_sells);
    }

    @Override
    public void deleteProductBycode(Long code) {
        apiProducts.deletebyproductid(code);
    }
}
