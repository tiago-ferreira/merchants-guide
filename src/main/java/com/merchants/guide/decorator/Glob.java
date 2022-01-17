package com.merchants.guide.decorator;

import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.types.SimpleCurrencyTypes;

public class Glob extends IntergalaticCurrency{
	
	public Glob(IntergalaticAmount money) {
		super(money);
	}
	
	@Override
	public String getCurrencyValues() {
		return PropertiesDAO.getProperty(SimpleCurrencyTypes.GLOB.getDescription());
	}

	@Override
	public String getCurrencyDescription() {
		return SimpleCurrencyTypes.GLOB.getDescription();
	}

}
