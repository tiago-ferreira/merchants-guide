package com.merchants.guide.factory;

import static org.junit.Assert.assertTrue;

import com.merchants.guide.decorator.Glob;
import com.merchants.guide.decorator.Gold;
import com.merchants.guide.decorator.IntergalaticAmount;
import com.merchants.guide.decorator.IntergalaticBaseAmount;
import org.junit.Assert;
import org.junit.Test;

public class CurrencyTypeFactoryTest {

	@Test
	public void testCreateInstace() {
		CurrencyTypeFactory currencyTypeFactory = new CurrencyTypeFactory();
		IntergalaticAmount amount = new IntergalaticBaseAmount();
		amount = currencyTypeFactory.createInstace(amount, "glob", 0.0);
		assertTrue(amount instanceof Glob);
	}
	
	@Test
	public void testCreateInstanceSimpleCurrencyType() {
		CurrencyTypeFactory currencyTypeFactory = new CurrencyTypeFactory();
		IntergalaticAmount amount = new IntergalaticBaseAmount();
		String clazz = "glob";
		Glob g = (Glob) currencyTypeFactory.createCurrencyInstance(clazz, amount);
		Assert.assertNotNull(g);
		Assert.assertEquals(g.getCurrencyDescription(), "glob");
	}
	
	@Test
	public void testCreateInstanceSpecialCurrencyType() {
		CurrencyTypeFactory currencyTypeFactory = new CurrencyTypeFactory();
		double factor = 10.0;
		IntergalaticAmount amount = new IntergalaticBaseAmount();
		String clazz = "gold";
		Gold g = (Gold) currencyTypeFactory.createCurrencyInstance(clazz, amount, factor);
		Assert.assertNotNull(g);
		Assert.assertEquals(g.getCurrencyDescription(), "gold");
	}

}
