package com.example.Sells_Service.Controller;


import com.example.Sells_Service.Dto.DtoSells;
import com.example.Sells_Service.Model.Sells;
import com.example.Sells_Service.Service.IServiceSells;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sells")
public class ControllerSells {

    @Autowired
    IServiceSells servisell;

    @Value("${server.port}")
    private int serverPort;

    @PostMapping("/saveSell")
    public String SaveSell (@RequestBody Sells sell){
        servisell.SaveSell(sell);
        return "The sell has been saved successfully";
    }

    @GetMapping("/findAll")
    public List<Sells> GetAllSells (){
    return servisell.GetAllSells();
    }

    @DeleteMapping("/DeleteSell/{id_sells}")
    public String DeleteSell(@PathVariable Long id_sells ){
        servisell.DeleteSells(id_sells);
        return "The Sell sellected has been deleted successfully";
    }

    @GetMapping("/findByID")
    public Sells FindSellById(@PathVariable Long id_Sells){
        return servisell.FindSellsById(id_Sells);
    }


    @GetMapping("/GetCartByIdSell/{id_sells}")
    public DtoSells GetShoppingCartByIdSell(@PathVariable Long id_sells){
        System.out.println("This is port:" + serverPort);
        return servisell.GetShoppingCartByIdSells(id_sells);
    }

}
