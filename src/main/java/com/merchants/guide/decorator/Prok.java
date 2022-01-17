package com.merchants.guide.decorator;

import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.types.SimpleCurrencyTypes;

public class Prok extends IntergalaticCurrency{

	
	public Prok(IntergalaticAmount money) {
		super(money);
	}
	
	@Override
	public String getCurrencyValues() {
		return PropertiesDAO.getProperty(SimpleCurrencyTypes.PROK.getDescription());
	}

	@Override
	public String getCurrencyDescription() {
		return SimpleCurrencyTypes.PROK.getDescription();
	}

}
