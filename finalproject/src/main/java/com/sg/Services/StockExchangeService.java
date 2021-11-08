package com.sg.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sg.entity.CompanyEntity;
import com.sg.entity.StockExchangeEntity;

@Service
public interface StockExchangeService {
	public List<StockExchangeEntity>getall();
	public void addStockExchange(StockExchangeEntity stockexchangeentity);
	public List<CompanyEntity>getallcompany();
}
