package com.merchants.guide.decorator;

import com.merchants.guide.dao.PropertiesDAO;
import com.merchants.guide.types.SpecialCurrencyTypes;

public class Silver extends IntergalaticCurrency {

	private double calculatedValue;
	private double factor;
	
	public Silver(IntergalaticAmount money, double factor) {
		super(money);
		this.factor = factor;
	}

	@Override
	public String getCurrencyValues() {
		calculatedValue = doValueCalculation();
		return String.valueOf(calculatedValue);
	}

	@Override
	public String getCurrencyDescription() {
		return SpecialCurrencyTypes.SILVER.getDescription();
	}

	private double doValueCalculation() {
		String decimal = PropertiesDAO.getProperty(SpecialCurrencyTypes.SILVER.getDescription());
		double value = Double.parseDouble(decimal);
		return value * factor;
	}
}
