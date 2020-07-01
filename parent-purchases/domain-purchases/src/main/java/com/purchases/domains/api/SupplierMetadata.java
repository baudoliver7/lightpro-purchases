package com.purchases.domains.api;

import com.infrastructure.core.DomainMetadata;

public class SupplierMetadata implements DomainMetadata {

	private final transient String domainName;
	private final transient String keyName;
	
	public SupplierMetadata() {
		this.domainName = "purchases.suppliers";
		this.keyName = "id";
	}
	
	public SupplierMetadata(final String domainName, final String keyName){
		this.domainName = domainName;
		this.keyName = keyName;
	}
	
	@Override
	public String domainName() {
		return this.domainName;
	}

	@Override
	public String keyName() {
		return this.keyName;
	}
	
	public String moduleIdKey(){
		return "moduleid";
	}	
	
	public static SupplierMetadata create(){
		return new SupplierMetadata();
	}
}
