package com.purchases.domains.impl;

import java.io.IOException;
import java.util.UUID;

import com.infrastructure.core.EntityNone;
import com.purchases.domains.api.Purchases;
import com.securities.api.Company;
import com.securities.api.Contacts;
import com.securities.api.Feature;
import com.securities.api.FeatureSubscribed;
import com.securities.api.Features;
import com.securities.api.Indicators;
import com.securities.api.Module;
import com.securities.api.ModuleType;

public final class PurchasesNone extends EntityNone<Purchases, UUID> implements Purchases {

	@Override
	public void activate(boolean arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Company company() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String description() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Features featuresAvailable() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Features featuresProposed() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Features featuresSubscribed() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Indicators indicators() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module install() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInstalled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSubscribed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String name() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int order() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String shortName() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module subscribe() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeatureSubscribed subscribeTo(Feature arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModuleType type() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module uninstall() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module unsubscribe() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unsubscribeTo(Feature arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacts contacts() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
