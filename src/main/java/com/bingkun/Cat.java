package com.bingkun;

public class Cat implements Animal {

	private final String name;

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return this.name;
	}
}
