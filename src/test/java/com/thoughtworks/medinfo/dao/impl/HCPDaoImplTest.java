package com.thoughtworks.medinfo.dao.impl;

import com.thoughtworks.medinfo.model.HCPRole;
import com.thoughtworks.medinfo.model.HCProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertEquals;

@Transactional
public class HCPDaoImplTest extends DaoTest {
	
	@Autowired
    HCPDaoImpl hcpDaoImpl;
	
	@Test
	public void all_fields_are_persisted() {
		HCProvider HCProvider = new HCProvider();
		HCProvider.setName("name1");
        HCProvider.setPhone("phone");
        HCProvider.setState("state1");
        HCProvider.setCity("city1");
        HCProvider.setStreet("street1");
        HCProvider.setRole(HCPRole.ANGANWADI_WORKER);
        HCProvider.setPincode("560012");

        hcpDaoImpl.save(HCProvider);
		List<HCProvider> HCProviders = hcpDaoImpl.findAll();
		assertEquals("name1",  HCProviders.get(0).getName());
		assertEquals("phone",  HCProviders.get(0).getPhone());
		assertEquals("state1", HCProviders.get(0).getState());
		assertEquals("city1",  HCProviders.get(0).getCity());
		assertEquals("street1",HCProviders.get(0).getStreet());
		assertEquals(HCPRole.ANGANWADI_WORKER,  HCProviders.get(0).getRole());
		assertEquals("560012", HCProviders.get(0).getPincode());

		hcpDaoImpl.delete(HCProvider);
	}
	
}
