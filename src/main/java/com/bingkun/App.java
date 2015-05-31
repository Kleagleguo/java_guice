package com.bingkun;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main( String[] args )
	{
		Injector injector = Guice.createInjector(new AnimalModule());
		Cat cat = injector.getInstance(Cat.class);
		System.out.println(cat.name());
		cat = injector.getInstance(Cat.class);
		System.out.println(cat.name());
		cat = injector.getInstance(Cat.class);
		System.out.println(cat.name());
	}
}
