package com.purchases.domains.api;

import java.io.IOException;

import com.securities.api.Contacts;
import com.securities.api.Module;

public interface Purchases extends Module {
	Contacts contacts() throws IOException;
}
