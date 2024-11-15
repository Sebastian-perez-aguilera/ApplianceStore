package com.example.Sells_Service.Service;

import com.example.Sells_Service.Dto.DtoSells;
import com.example.Sells_Service.Model.Sells;

import java.util.List;

public interface IServiceSells {

    public void SaveSell (Sells sell);

    public void DeleteSells (Long id_sells);

     List<Sells> GetAllSells();

     public Sells FindSellsById (Long id_sells);


    public DtoSells GetShoppingCartByIdSells (Long id_sells);
}
