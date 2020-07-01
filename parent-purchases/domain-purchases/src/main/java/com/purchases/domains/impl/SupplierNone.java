package com.purchases.domains.impl;

import java.io.IOException;

import com.infrastructure.core.GuidKeyEntityNone;
import com.purchases.domains.api.Purchases;
import com.purchases.domains.api.Supplier;
import com.securities.api.Company;
import com.securities.api.ContactNature;
import com.securities.impl.CompanyNone;

public final class SupplierNone extends GuidKeyEntityNone<Supplier> implements Supplier {

	@Override
	public Company company() throws IOException {
		return new CompanyNone();
	}

	@Override
	public String photo() throws IOException {
		return null;
	}

	@Override
	public Purchases module() throws IOException {
		return new PurchasesNone();
	}

	@Override
	public String fax() throws IOException {
		return null;
	}

	@Override
	public String locationAddress() throws IOException {
		return null;
	}

	@Override
	public String mail() throws IOException {
		return null;
	}

	@Override
	public String mobile() throws IOException {
		return null;
	}

	@Override
	public String name() throws IOException {
		return null;
	}

	@Override
	public ContactNature nature() throws IOException {
		return ContactNature.NONE;
	}

	@Override
	public String phone() throws IOException {
		return null;
	}

	@Override
	public String poBox() throws IOException {
		return null;
	}

	@Override
	public void updateAddresses(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6) throws IOException {
		
	}

	@Override
	public String webSite() throws IOException {
		return null;
	}
}
