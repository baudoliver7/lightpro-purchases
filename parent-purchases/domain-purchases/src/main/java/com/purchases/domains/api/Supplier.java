package com.purchases.domains.api;

import java.io.IOException;
import java.util.UUID;

import com.securities.api.Contact;

public interface Supplier extends Contact {
	UUID id();
	Purchases module() throws IOException;
}
