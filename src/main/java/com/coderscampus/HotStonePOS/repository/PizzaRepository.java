package com.coderscampus.HotStonePOS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.HotStonePOS.domain.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
