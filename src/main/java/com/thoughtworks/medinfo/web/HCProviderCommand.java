package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.*;

public class HCProviderCommand extends HCProvider {

	private static final long serialVersionUID = -4686811929329857418L;

	private Boolean selected = false;
	
	public HCProviderCommand() {}

	public HCProviderCommand(HCProvider HCProvider) {
		setId(HCProvider.getId());
		setName(HCProvider.getName());
		setPrice(HCProvider.getPrice());
		setDescription(HCProvider.getDescription());
	}

	public HCProvider toHCPObject() {
		HCProvider HCProvider = new HCProvider();
		HCProvider.setId(getId());
		HCProvider.setName(getName());
		HCProvider.setPrice(getPrice());
		HCProvider.setDescription(getDescription());
		return HCProvider;
	}
	
	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean changed) {
		this.selected = changed;
	}
	
}