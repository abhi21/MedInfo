package com.thoughtworks.medinfo.dao.impl;

import com.thoughtworks.medinfo.model.*;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
public class HCPDaoImplTest extends DaoTest {
	
	@Autowired
    HCPDaoImpl hcpDaoImpl;
	
	@Test
	public void all_fields_are_persisted() {
		HCProvider HCProvider = new HCProvider();
		HCProvider.setName("Name1");
		HCProvider.setPrice(BigDecimal.valueOf(13.99));
		HCProvider.setDescription("this HCProvider is awesome");
		hcpDaoImpl.save(HCProvider);
		List<HCProvider> HCProviders = hcpDaoImpl.findAll();
		Assert.assertEquals("Name1", HCProviders.get(0).getName());
		Assert.assertEquals(BigDecimal.valueOf(13.99), HCProviders.get(0).getPrice());
		Assert.assertEquals("this HCProvider is awesome", HCProviders.get(0).getDescription());
		hcpDaoImpl.delete(HCProvider);
	}
	
}
