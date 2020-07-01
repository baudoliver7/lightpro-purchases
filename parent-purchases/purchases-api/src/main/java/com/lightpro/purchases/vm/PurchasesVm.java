package com.lightpro.purchases.vm;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.purchases.domains.api.Purchases;

public class PurchasesVm {
	
	private final transient Purchases origin;
	
	public PurchasesVm(){
		throw new UnsupportedOperationException("#PurchasesVm()");
	}
	
	public PurchasesVm(final Purchases origin) {
        this.origin = origin;
    }
	
	@JsonGetter
	public UUID getId(){
		return origin.id();
	}
	
	@JsonGetter
	public String getName() throws IOException {
		return origin.name();
	}
	
	@JsonGetter
	public String getShortName() throws IOException {
		return origin.shortName();
	}
}
