package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HCPGrid {
	
	@Valid
	private Map<Long, HCProviderCommand> hcpMap;
	
	public HCPGrid() {
	}
	
	public HCPGrid(List<HCProvider> HCProviders) {
		hcpMap = new LinkedHashMap<Long, HCProviderCommand>();
		for (HCProvider HCProvider : HCProviders)
			hcpMap.put(HCProvider.getId(), new HCProviderCommand(HCProvider));
	}
	
	public List<HCProvider> getHCP() {
		List<HCProvider> HCProviders = new ArrayList<HCProvider>();
		for (HCProviderCommand hcpCommand : hcpMap.values()) {
			HCProviders.add(hcpCommand.toHCPObject());
		}
		return HCProviders;
	}

	public Map<Long, HCProviderCommand> getHcpMap() {
		return hcpMap;
	}

	public void setHcpMap(Map<Long, HCProviderCommand> hcpMap) {
		this.hcpMap = hcpMap;
	}
	
}
