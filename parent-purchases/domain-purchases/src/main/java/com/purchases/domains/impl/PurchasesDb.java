package com.purchases.domains.impl;

import java.io.IOException;

import com.infrastructure.core.GuidKeyEntityBase;
import com.infrastructure.datasource.Base;
import com.purchases.domains.api.Purchases;
import com.securities.api.Company;
import com.securities.api.Contacts;
import com.securities.api.Feature;
import com.securities.api.FeatureSubscribed;
import com.securities.api.Features;
import com.securities.api.Indicators;
import com.securities.api.Module;
import com.securities.api.ModuleType;

public final class PurchasesDb extends GuidKeyEntityBase<Purchases> implements Purchases {

	private final transient Base base;
	private final transient Module origin;
	
	public PurchasesDb(final Base base, final Module module) {
		super(module.id());
		this.base = base;
		this.origin = module;
	}

	@Override
	public void activate(boolean active) throws IOException {
		origin.activate(active);
	}

	@Override
	public Company company() throws IOException {
		return origin.company();
	}

	@Override
	public String description() throws IOException {
		return origin.description();
	}

	@Override
	public Features featuresAvailable() throws IOException {
		return origin.featuresAvailable();
	}

	@Override
	public Features featuresProposed() throws IOException {
		return origin.featuresProposed();
	}

	@Override
	public Features featuresSubscribed() throws IOException {
		return origin.featuresSubscribed();
	}

	@Override
	public Indicators indicators() throws IOException {
		return origin.indicators();
	}

	@Override
	public Module install() throws IOException {
		Module module = origin.install();
		return new PurchasesDb(base, module);
	}

	@Override
	public boolean isActive() {
		return origin.isActive();
	}

	@Override
	public boolean isInstalled() {
		return origin.isInstalled();
	}

	@Override
	public boolean isSubscribed() {
		return origin.isSubscribed();
	}

	@Override
	public String name() throws IOException {
		return origin.name();
	}

	@Override
	public int order() throws IOException {
		return origin.order();
	}

	@Override
	public String shortName() throws IOException {
		return origin.shortName();
	}

	@Override
	public Module subscribe() throws IOException {
		return origin.subscribe();
	}

	@Override
	public FeatureSubscribed subscribeTo(Feature feature) throws IOException {
		return origin.subscribeTo(feature);
	}

	@Override
	public ModuleType type() throws IOException {
		return origin.type();
	}

	@Override
	public Module uninstall() throws IOException {
		Module module = origin.uninstall();
		return new PurchasesDb(base, module);
	}

	@Override
	public Module unsubscribe() throws IOException {
		return origin.unsubscribe();
	}

	@Override
	public void unsubscribeTo(Feature feature) throws IOException {
		origin.unsubscribeTo(feature);
	}

	@Override
	public Contacts contacts() throws IOException {
		return company().moduleAdmin().contacts();
	}

}
