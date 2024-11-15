package com.example.Sells_Service.Service;

import com.example.Sells_Service.Dto.DtoSells;
import com.example.Sells_Service.Dto.DtoShoppingCart;
import com.example.Sells_Service.Model.Sells;
import com.example.Sells_Service.Repository.ApiShoppingCart;
import com.example.Sells_Service.Repository.IRepositorySells;
import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceSells implements IServiceSells{

    @Autowired
    IRepositorySells reposells;

    @Autowired
    ApiShoppingCart apicart;

    @Override
    public void SaveSell(Sells sell) {
        reposells.save(sell);
    }

    @Override
    public void DeleteSells(Long id_sells) {
        reposells.deleteById(id_sells);
    }

    @Override
    public List<Sells> GetAllSells() {
        return reposells.findAll();
    }

    @Override
    public Sells FindSellsById(Long id_sells) {
        return reposells.findById(id_sells).orElse(null);
    }

    @Override
    @CircuitBreaker(name="ShoppingCart-Service", fallbackMethod = "fallbackmethodgetcartbyidsells")
    @Retry(name="ShoppingCart-Service")
    public DtoSells GetShoppingCartByIdSells(Long id_sells) {

        Sells sells = reposells.findById(id_sells).orElse(null);

        List<DtoShoppingCart> dtoCart = apicart.dtoshoppingcart(id_sells);

        assert sells != null;
        return new DtoSells(sells.getId_sells(), sells.getDate_of_sell(), dtoCart);



    }

    DtoSells fallbackmethodgetcartbyidsells (Throwable throwable){
        return new DtoSells(999999l,null,null);
    }
}
