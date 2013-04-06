package com.thoughtworks.medinfo.dao;

import com.thoughtworks.medinfo.model.*;

import java.util.List;

public interface HCPDao {

	HCProvider get(Long id);
	void save(HCProvider HCProvider);
	void delete(HCProvider HCProvider);
	List<HCProvider> findAll();

    List<HCProvider> findByPincode(String msisdn);
}
