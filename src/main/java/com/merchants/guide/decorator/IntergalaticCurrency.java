package com.merchants.guide.decorator;

import com.merchants.guide.utils.RomanToDecimal;

public abstract class IntergalaticCurrency extends IntergalaticAmount{

	RomanToDecimal rd = new RomanToDecimal();
	IntergalaticAmount intergalaticAmount;
	
	public IntergalaticCurrency(IntergalaticAmount intergalaticAmount) {
		this.intergalaticAmount = intergalaticAmount;
	}
	
	@Override
	public String value() {
		return intergalaticAmount.value() + getCurrencyValues();
	}

	@Override
	public String description() {
		return intergalaticAmount.description() +" "+ getCurrencyDescription();
	}
	
	public String result() {
		String value =  value();
		String answer = processValue(value);
		return answer;
	}
	
	private String processValue(String value) {
		if(rd.isRoman(value)){
			Integer decimal = rd.romanToDecimal(value);
			return  decimal.toString();
		} 	
		return value;
	}

	public abstract String getCurrencyValues();
	public abstract String getCurrencyDescription();

}
