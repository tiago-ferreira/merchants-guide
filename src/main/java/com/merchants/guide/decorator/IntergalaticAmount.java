package com.merchants.guide.decorator;

public abstract class IntergalaticAmount {
	public abstract String value();
	public abstract String description();
	public String result() {
		return value();
	}
}
