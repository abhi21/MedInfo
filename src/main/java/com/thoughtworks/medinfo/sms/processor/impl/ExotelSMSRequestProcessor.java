package com.thoughtworks.medinfo.sms.processor.impl;

import com.thoughtworks.medinfo.sms.processor.SMSRequestProcessor;

import javax.servlet.http.HttpServletRequest;

public class ExotelSMSRequestProcessor implements SMSRequestProcessor {

    public ExotelSMSRequestProcessor() {
    }

    @Override
    public String getPincode(HttpServletRequest httpServletRequest) {
        String body = httpServletRequest.getParameter("Body");
        return body.substring(body.indexOf(" ") + 1, body.length());
    }
}
