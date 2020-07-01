package com.purchases.domains.api;

import java.io.IOException;

import com.infrastructure.core.GuidKeyAdvancedQueryable;
import com.securities.api.Contact;

public interface Suppliers extends GuidKeyAdvancedQueryable<Supplier> {
	Supplier add(Contact contact) throws IOException;
	boolean contains(Contact contact) throws IOException;
}
