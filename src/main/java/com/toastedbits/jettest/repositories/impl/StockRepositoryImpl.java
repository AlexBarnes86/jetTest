package com.toastedbits.jettest.repositories.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toastedbits.jettest.models.Stock;
import com.toastedbits.jettest.repositories.StockRepository;

@Repository("stockRepository")
public class StockRepositoryImpl implements StockRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Stock stock){
		sessionFactory.getCurrentSession().save(stock);
		
	}
	
	public void update(Stock stock){
		sessionFactory.getCurrentSession().update(stock);
	}
	
	public void delete(Stock stock){
		sessionFactory.getCurrentSession().delete(stock);
	}
	
	public Stock findByStockCode(String stockCode){
		Query query = sessionFactory.getCurrentSession().
				createQuery("FROM Stock WHERE stockCode = :stockCode");
				query.setParameter("stockCode", stockCode);
		if(query.list().size() > 0) {
			return (Stock) query.list().get(0);
		}
		else {
			return null;
		}
	}
}
