package com.purchases.domains.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.infrastructure.core.GuidKeyAdvancedQueryableDb;
import com.infrastructure.core.HorodateMetadata;
import com.infrastructure.datasource.Base;
import com.infrastructure.datasource.QueryBuilder;
import com.purchases.domains.api.Purchases;
import com.purchases.domains.api.Supplier;
import com.purchases.domains.api.SupplierMetadata;
import com.purchases.domains.api.Suppliers;
import com.securities.api.Contact;
import com.securities.api.ContactMetadata;

public final class SuppliersDb extends GuidKeyAdvancedQueryableDb<Supplier, SupplierMetadata> implements Suppliers {

	private final transient Purchases module;
	
	public SuppliersDb(final Base base, final Purchases module) {
		super(base, "Fournisseur introuvable !");
		this.module = module;
	}

	@Override
	public Supplier add(Contact contact) throws IOException {
		Supplier supplier = build(contact.id());
		
		if(contains(supplier))
			throw new IllegalArgumentException("Le client existe déjà !");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(dm.moduleIdKey(), module.id());
		ds.set(contact.id(), params);		
		
		return build(contact.id());
	}

	@Override
	protected QueryBuilder buildQuery(String filter) throws IOException {
		List<Object> params = new ArrayList<Object>();
		filter = StringUtils.defaultString(filter);

		ContactMetadata persDm = ContactMetadata.create();		
		String statement = String.format("%s suppl "
				+ "JOIN view_contacts vctc ON vctc.%s=suppl.%s "
				+ "WHERE (vctc.name1 ILIKE ? OR vctc.name2 ILIKE ?) AND suppl.%s=?", 
				dm.domainName(), 
				persDm.keyName(), dm.keyName(),
				dm.moduleIdKey());
		
		params.add("%" + filter + "%");
		params.add("%" + filter + "%");
		params.add(module.id());
		
		String orderClause;	
		HorodateMetadata hm = new HorodateMetadata();
		
		orderClause = String.format("ORDER BY suppl.%s DESC", hm.dateCreatedKey());
				
		String keyResult = String.format("suppl.%s", dm.keyName());
		return base.createQueryBuilder(ds, statement, params, keyResult, orderClause);
	}

	@Override
	protected Supplier newOne(UUID id) {
		Contact contact;
		
		try {
			contact = module.company().moduleAdmin().contacts().build(id);
		} catch (IOException e) {
			throw new RuntimeException(e);			
		}
		
		return new SupplierDb(base, contact);
	}

	@Override
	public Supplier none() {
		return new SupplierNone();
	}

	@Override
	public boolean contains(Contact contact) throws IOException {
		Supplier supplier = build(contact.id());
		
		if(supplier.isNone())
			return false;
		
		return contains(supplier);
	}

}
