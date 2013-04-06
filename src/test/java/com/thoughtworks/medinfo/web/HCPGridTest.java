package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.*;
import junit.framework.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HCPGridTest {
	
	@Test
	public void two_valid_HCPs_should_not_have_violations() {

		List<HCProvider> HCProviders = new ArrayList<HCProvider>();

		HCProviders.add(new HCProvider());
		HCProviders.get(0).setName("name1");
		HCProviders.get(0).setPrice(BigDecimal.valueOf(13.99));
		HCProviders.get(0).setDescription("description1");

		HCProviders.add(new HCProvider());
		HCProviders.get(1).setName("name2");
		HCProviders.get(1).setPrice(BigDecimal.valueOf(14.99));
		HCProviders.get(1).setDescription("description2");

		HCPGrid HCPGrid = new HCPGrid(HCProviders);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<HCPGrid>> violations = validator.validate(HCPGrid);
		Assert.assertTrue(violations.isEmpty());
	
	}

    @Test
    public void should_accept_valid_price() {

        List<HCProvider> HCProviders = new ArrayList<HCProvider>();

        HCProviders.add(new HCProvider());
        HCProviders.get(0).setName("name1");
        HCProviders.get(0).setPrice(BigDecimal.valueOf(13.99));
        HCProviders.get(0).setDescription("description1");

        HCPGrid hcpGrid = new HCPGrid(HCProviders);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<HCPGrid>> violations = validator.validate(hcpGrid);
        Assert.assertTrue(violations.isEmpty());
    }

	@Test
	public void invalid_price_should_have_violations() {

		List<HCProvider> HCProviders = new ArrayList<HCProvider>();

		HCProviders.add(new HCProvider());
		HCProviders.get(0).setName("name1");
		HCProviders.get(0).setPrice(BigDecimal.valueOf(348324689));
		HCProviders.get(0).setDescription("description1");

		HCPGrid hcpGrid = new HCPGrid(HCProviders);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<HCPGrid>> violations = validator.validate(hcpGrid);
		Assert.assertFalse(violations.isEmpty());
		for (ConstraintViolation<HCPGrid> violation : violations) {
			Assert.assertEquals("must be less than or equal to 99999", violation.getMessage());
		}
	
	}

}
