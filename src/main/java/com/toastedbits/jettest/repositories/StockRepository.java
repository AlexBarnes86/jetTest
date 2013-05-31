package com.toastedbits.jettest.repositories;

import com.toastedbits.jettest.models.Stock;

public interface StockRepository {
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}
