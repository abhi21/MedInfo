package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.*;

public class HCProviderCommand extends HCProvider {

	private static final long serialVersionUID = -4686811929329857418L;

	private Boolean selected = false;
	
	public HCProviderCommand() {}

	public HCProviderCommand(HCProvider HCProvider) {
		setId(HCProvider.getId());
		setName(HCProvider.getName());
        setPhone(HCProvider.getPhone());
        setCity(HCProvider.getCity());
        setPincode(HCProvider.getPincode());
        setRole(HCProvider.getRole());
        setStreet(HCProvider.getStreet());
        setState(HCProvider.getState());
	}

	public HCProvider toHCPObject() {
		HCProvider HCProvider = new HCProvider();
		HCProvider.setId(getId());
		HCProvider.setName(getName());
        HCProvider.setCity(getCity());
        HCProvider.setState(getState());
        HCProvider.setStreet(getStreet());
        HCProvider.setRole(getRole());
        HCProvider.setPhone(getPhone());
        HCProvider.setPincode(getPincode());

		return HCProvider;
	}
	
	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean changed) {
		this.selected = changed;
	}
	
}