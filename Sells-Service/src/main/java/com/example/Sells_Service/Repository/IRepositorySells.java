package com.example.Sells_Service.Repository;

import com.example.Sells_Service.Model.Sells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorySells extends JpaRepository<Sells, Long> {
}
