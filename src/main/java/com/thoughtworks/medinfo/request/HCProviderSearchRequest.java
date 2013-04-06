package com.thoughtworks.medinfo.request;

import org.springframework.stereotype.Service;

@Service
public class HCProviderSearchRequest {
    private String pincode;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
