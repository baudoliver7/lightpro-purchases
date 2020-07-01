package com.lightpro.purchases.rs;

import java.io.IOException;

import com.purchases.domains.api.Purchases;
import com.purchases.domains.impl.PurchasesDb;
import com.securities.api.BaseRs;
import com.securities.api.Module;
import com.securities.api.ModuleType;

public abstract class PurchasesBaseRs extends BaseRs {
	protected Purchases purchases() throws IOException {
		Module module = currentCompany().modulesInstalled().get(ModuleType.PURCHASES);
		return new PurchasesDb(app().base(), module);
	}
	
	protected Purchases purchases(Module module) throws IOException {
		return new PurchasesDb(app().base(), module);
	}
}
