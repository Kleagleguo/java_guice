package com.bingkun;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.inject.*;
import com.google.inject.util.Types;

/**
 * Created by guobingkun on 2/28/15.
 */
public class AnimalModule implements Module {
	@Override
	public void configure(Binder binder) {
		System.out.println("biding");
		//Key<Supplier<Cat>> supplierKey = (Key) Key.get(Types.newParameterizedType(Supplier.class, Cat.class));

		Key<Supplier<Cat>> supplierKey = (Key) Key.get(new TypeLiteral<Supplier<Cat>>() {});

		binder.bind(supplierKey)
					.toProvider(new Provider<Supplier<Cat>>() {
						@Override
						public Supplier<Cat> get() {
							return Suppliers.ofInstance(new Cat(String.valueOf(System.currentTimeMillis())));
						}
					})
					.in(Singleton.class);

		binder.bind(Key.get(Cat.class))
					.toProvider(new SupplierProvider<Cat>(supplierKey));
	}
}
