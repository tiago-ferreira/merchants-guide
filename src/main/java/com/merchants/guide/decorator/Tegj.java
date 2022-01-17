package com.merchants.guide.decorator;

import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.types.SimpleCurrencyTypes;

public class Tegj extends IntergalaticCurrency {

	
	public Tegj(IntergalaticAmount money) {
		super(money);
	}

	@Override
	public String getCurrencyValues() {
		return PropertiesDAO.getProperty(SimpleCurrencyTypes.TEGJ.getDescription());
	}

	@Override
	public String getCurrencyDescription() {
		return SimpleCurrencyTypes.TEGJ.getDescription();
	}

}
