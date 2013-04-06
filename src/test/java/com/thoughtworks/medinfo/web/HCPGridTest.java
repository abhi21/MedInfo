package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.HCProvider;
import junit.framework.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.thoughtworks.medinfo.model.HCPRole.ANGANWADI_WORKER;

public class HCPGridTest {
	
	@Test
	public void two_valid_HCPs_should_not_have_violations() {

		List<HCProvider> hcproviders = new ArrayList<HCProvider>();

        HCProvider hcProvider = new HCProvider();
		hcProvider.setName("name1");
		hcProvider.setPhone("phone");
		hcProvider.setState("state1");
		hcProvider.setCity("city1");
		hcProvider.setStreet("street1");
		hcProvider.setRole(ANGANWADI_WORKER);
		hcProvider.setPincode("560012");
        hcproviders.add(hcProvider);

        HCProvider hcProvider2 = new HCProvider();
        hcProvider2.setName("name2");
        hcProvider2.setPhone("phone2");
        hcProvider2.setState("state2");
        hcProvider2.setCity("city2");
        hcProvider2.setStreet("street2");
        hcProvider2.setRole(ANGANWADI_WORKER);
        hcProvider2.setPincode("560011");
        hcproviders.add(hcProvider2);

		HCPGrid HCPGrid = new HCPGrid(hcproviders);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<HCPGrid>> violations = validator.validate(HCPGrid);
		Assert.assertTrue(violations.isEmpty());
	
	}



}
