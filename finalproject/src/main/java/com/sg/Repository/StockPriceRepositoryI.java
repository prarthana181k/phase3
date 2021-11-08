package com.sg.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sg.entity.StockPrice;

@Repository
public interface StockPriceRepositoryI extends JpaRepository<StockPrice,Integer> {

	@Query("select s from  StockPrice s where s.companyCode=?1 and s.StockExchange=?2" )
	List<StockPrice>allStockPrice(int Companycode,String exchangename,Date in,Date out);
}