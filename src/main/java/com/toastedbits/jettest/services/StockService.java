package com.toastedbits.jettest.services;

import com.toastedbits.jettest.models.Stock;

public interface StockService {
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}
