package com.thoughtworks.medinfo.model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;


public class HCProviderTest {
	
	@Test
	public void assert_that_certain_fields_cant_be_null_or_blank() {
		HCProvider HCProvider = new HCProvider();
		Map<String, ConstraintViolation<HCProvider>> violationsMap = validate(HCProvider);
		assertTrue(violationsMap.get("name").getMessageTemplate().contains("NotEmpty"));
		assertTrue(violationsMap.get("phone").getMessageTemplate().contains("NotNull"));
		assertTrue(violationsMap.get("role").getMessageTemplate().contains("NotNull"));
		assertTrue(violationsMap.get("state").getMessageTemplate().contains("NotNull"));
		assertTrue(violationsMap.get("city").getMessageTemplate().contains("NotNull"));
		assertTrue(violationsMap.get("pincode").getMessageTemplate().contains("NotNull"));
	}
	
	private <T> Map<String, ConstraintViolation<T>>  validate(T hcp) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Map<String, ConstraintViolation<T>> violations = new HashMap<String, ConstraintViolation<T>>();
		for (ConstraintViolation<T> violation : validator.validate(hcp)) {
			violations.put(violation.getPropertyPath().toString(), violation);
		}
		return violations;
	}

}
