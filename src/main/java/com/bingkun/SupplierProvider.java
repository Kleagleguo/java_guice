package com.bingkun;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;

/**
 */
public class SupplierProvider<T> implements Provider<T>
{
  private final Key<Supplier<T>> supplierKey;

  private Provider<Supplier<T>> supplierProvider;

  public SupplierProvider(
          Key<Supplier<T>> supplierKey
  )
  {
    this.supplierKey = supplierKey;
  }

  @Inject
  public void configure(Injector injector)
  {
    System.out.println("here");
    this.supplierProvider = injector.getProvider(supplierKey);
  }

	@Inject
	public void configure2(Injector injector)
	{
		System.out.println("here2");
		//this.supplierProvider = injector.getProvider(supplierKey);
	}

	@Inject
	public void configure3(Injector injector)
	{
		System.out.println("here3");
		//this.supplierProvider = injector.getProvider(supplierKey);
	}

  @Override
  public T get()
  {
    return supplierProvider.get().get();
  }
}
