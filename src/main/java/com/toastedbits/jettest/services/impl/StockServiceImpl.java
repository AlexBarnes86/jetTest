package com.toastedbits.jettest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toastedbits.jettest.services.StockService;
import com.toastedbits.jettest.repositories.StockRepository;
import com.toastedbits.jettest.models.Stock;

@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	public void save(Stock stock) {
		stockRepository.save(stock);
	}
	
	public void update(Stock stock) {
		stockRepository.update(stock);
	}
	
	public void delete(Stock stock) {
		stockRepository.delete(stock);
	}
	
	public Stock findByStockCode(String stockCode) {
		return stockRepository.findByStockCode(stockCode);
	}
}
