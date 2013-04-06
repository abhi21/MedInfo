package com.thoughtworks.medinfo.sms.processor.impl;

import com.thoughtworks.medinfo.sms.processor.SMSRequestProcessor;

import javax.servlet.http.HttpServletRequest;

public class ExotelSMSRequestProcessor implements SMSRequestProcessor {

    private String msisdn;
    private HttpServletRequest httpServletRequest;

    public ExotelSMSRequestProcessor() {
    }

    public ExotelSMSRequestProcessor(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public String getPincode() {
        return httpServletRequest.getParameter("Body");
    }
}
