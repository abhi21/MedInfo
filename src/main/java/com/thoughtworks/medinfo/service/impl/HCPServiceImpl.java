package com.thoughtworks.medinfo.service.impl;

import com.thoughtworks.medinfo.dao.HCPDao;
import com.thoughtworks.medinfo.model.HCProvider;
import com.thoughtworks.medinfo.service.HCPService;
import com.thoughtworks.medinfo.web.HCProviderCommand;
import com.thoughtworks.medinfo.web.HCPGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HCPServiceImpl implements HCPService {
	
	@Autowired
    HCPDao hcpDao;
	
	@Transactional(readOnly = true)
	public HCProvider get(Long id) {
		return hcpDao.get(id);
	}

	@Transactional
	public void delete(HCProvider HCProvider) {
		hcpDao.delete(HCProvider);
	}

	@Transactional(readOnly = true)
	public HCPGrid findAll() {
		return new HCPGrid(hcpDao.findAll());
	}

	@Transactional
	public void save(HCProviderCommand hcpCommand) {
		hcpDao.save(hcpCommand.toHCPObject());
	}

	@Transactional
	public void saveAll(HCPGrid HCPGrid) {
		for (HCProvider HCProvider : HCPGrid.getHCP())
			hcpDao.save(HCProvider);
	}
	
	@Transactional(readOnly = true)
	public void viewAll(HCPGrid HCPGrid) {
		HCPGrid allHCPs = findAll();
		allHCPs.getHcpMap().putAll(HCPGrid.getHcpMap());
		HCPGrid.setHcpMap(allHCPs.getHcpMap());
	}
}
