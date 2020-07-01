package com.purchases.domains.impl;

import java.io.IOException;
import java.util.UUID;

import com.infrastructure.core.GuidKeyEntityDb;
import com.infrastructure.datasource.Base;
import com.purchases.domains.api.Purchases;
import com.purchases.domains.api.Supplier;
import com.purchases.domains.api.SupplierMetadata;
import com.securities.api.Company;
import com.securities.api.Contact;
import com.securities.api.ContactNature;
import com.securities.impl.ModuleInstalledDb;

public final class SupplierDb extends GuidKeyEntityDb<Supplier, SupplierMetadata> implements Supplier {

	private final transient Contact origin;
	
	public SupplierDb(final Base base, final Contact contact) {
		super(base, contact.id(), "Fournisseur introuvable !");
		this.origin = contact;
	}

	@Override
	public Company company() throws IOException {
		return origin.company();
	}

	@Override
	public String fax() throws IOException {
		return origin.fax();
	}

	@Override
	public String locationAddress() throws IOException {
		return origin.locationAddress();
	}

	@Override
	public String mail() throws IOException {
		return origin.mail();
	}

	@Override
	public String mobile() throws IOException {
		return origin.mobile();
	}

	@Override
	public String name() throws IOException {
		return origin.name();
	}

	@Override
	public ContactNature nature() throws IOException {
		return origin.nature();
	}

	@Override
	public String phone() throws IOException {
		return origin.phone();				
	}

	@Override
	public String photo() throws IOException {
		return origin.photo();
	}

	@Override
	public String poBox() throws IOException {
		return origin.poBox();	
	}

	@Override
	public void updateAddresses(String locationAddress, String phone, String mobile, String fax, String mail, String poBox, String webSite) throws IOException {
		origin.updateAddresses(locationAddress, phone, mobile, fax, mail, poBox, webSite);
	}

	@Override
	public String webSite() throws IOException {
		return origin.webSite();
	}

	@Override
	public Purchases module() throws IOException {
		UUID moduleId = ds.get(dm.moduleIdKey());
		return new PurchasesDb(base, ModuleInstalledDb.create(base, moduleId));
	}

}
