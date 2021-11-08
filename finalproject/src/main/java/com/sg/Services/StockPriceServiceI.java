package com.sg.Services;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sg.entity.StockPrice;

public interface StockPriceServiceI {
	 
	void save(MultipartFile file);

	List<StockPrice> allStockPrice(int Companycode, String exchangename, Date in, Date out);
}
