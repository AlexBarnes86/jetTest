package com.toastedbits.jettest.controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import org.springframework.transaction.annotation.Transactional;

import com.toastedbits.jettest.models.Stock;
import com.toastedbits.jettest.services.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	StockService stocks;
	
	@RequestMapping(value="/{code}", method = RequestMethod.GET)
	public String hello(ModelMap model, @PathVariable String code) {
		Stock stock = stocks.findByStockCode(code);
		model.addAttribute("stock", stock);
		return "stock";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String hello(ModelMap model, @RequestParam String code, @RequestParam String name) {
		Stock myStock = new Stock(code, name);
		stocks.save(myStock);
		return "redirect:/spring/stock/" + code;
	}
}
