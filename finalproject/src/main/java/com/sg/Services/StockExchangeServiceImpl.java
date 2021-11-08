package com.sg.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.Repository.CompanyRepositoryI;
import com.sg.Repository.StockExchangeRepositoryI;
import com.sg.entity.CompanyEntity;
import com.sg.entity.StockExchangeEntity;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
  
	 @Autowired
	  private StockExchangeRepositoryI stockexchangedao;
	  @Autowired
	  private CompanyRepositoryI companyrepository;
	
	 @Override
	 public List<StockExchangeEntity>getall() {
		return stockexchangedao.findAll();
	 }

   	 @Override
	 public void addStockExchange(StockExchangeEntity stockexchangeentity) {
   		 stockexchangedao.save(stockexchangeentity);
	 }

	 @Override
	 public List<CompanyEntity> getallcompany() {
		return companyrepository.findAll();
	 }

}
