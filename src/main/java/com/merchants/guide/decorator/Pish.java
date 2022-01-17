package com.merchants.guide.decorator;

import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.types.SimpleCurrencyTypes;

public class Pish extends IntergalaticCurrency {

	
	public Pish(IntergalaticAmount money) {
		super(money);
	}
	
	@Override
	public String getCurrencyValues() {
		return PropertiesDAO.getProperty(SimpleCurrencyTypes.PISH.getDescription());
	}

	@Override
	public String getCurrencyDescription() {
		return SimpleCurrencyTypes.PISH.getDescription();
	}

}
