package com.sg.Services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sg.Repository.StockPriceRepositoryI;
import com.sg.entity.StockExchangeEntity;
import com.sg.entity.StockPrice;

@Service
public class StockPriceServiceImpl  implements StockPriceServiceI{

	@Autowired
	private StockPriceRepositoryI stockpricerepo;
	
	@Autowired
	  private EntityManager entitymanager;
	
	@Override
    
	public List<StockPrice> allStockPrice(int Companycode, String exchangename, Date in, Date out) {
		// TODO Auto-generated method stub
		return stockpricerepo.findAll();
	}
	@Override
	@Transactional
	public void save(MultipartFile file) throws RuntimeException{
		try {
			List<StockPrice> stockPriceList = ExcelHelper.excelToStockPriceEntity(file.getInputStream());
			//stockpricedao.saveAll(stockPriceList);
			for(StockPrice stockent:stockPriceList)
			{ String exch = stockent.getStockExchange();
				TypedQuery<StockExchangeEntity> q1 =   entitymanager.createQuery(" select c from StockExchangeEntity c where c.StockExchange =: name",StockExchangeEntity.class);
		        ((javax.persistence.Query) q1).setParameter("name", "BSE"); 
		 
		        StockExchangeEntity c =  (StockExchangeEntity) ((javax.persistence.Query) q1).getSingleResult();
				stockent.setStockExchangeent(c);
				
		        stockpricerepo.save(stockent);
		        System.out.println(stockent.getStockExchangeent().getStockExchangenid());
		       
			}
			
			
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	

}