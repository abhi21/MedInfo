package com.thoughtworks.medinfo.service;

import com.thoughtworks.medinfo.model.HCProvider;
import com.thoughtworks.medinfo.web.HCPGrid;
import com.thoughtworks.medinfo.web.HCProviderCommand;

import java.util.List;

public interface HCPService {

    HCProvider get(Long id);

    void save(HCProviderCommand hcpCommand);

    void delete(HCProvider HCProvider);

    HCPGrid findAll();

    void saveAll(HCPGrid HCPGrid);

    void viewAll(HCPGrid HCPGrid);

    List<HCProvider> findByPincode(String pincode);

    void deleteAll(HCPGrid hcpGrid);
}
