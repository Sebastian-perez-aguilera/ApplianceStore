package com.example.Sells_Service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoSells {

    Long id_sells;
    LocalDate date_of_sell;
    List<DtoShoppingCart> dtosells;




}
