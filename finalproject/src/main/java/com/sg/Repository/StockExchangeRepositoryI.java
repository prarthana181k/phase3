package com.sg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.entity.StockExchangeEntity;

@Repository
public interface StockExchangeRepositoryI extends JpaRepository<StockExchangeEntity, Integer>{

}
