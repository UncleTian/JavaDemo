package com.art2cat.dev;

public class Trader {

	private final String name;
	private final String city;

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public Trader(String name, String city) {

		this.name = name;
		this.city = city;
	}
}
