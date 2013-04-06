package com.thoughtworks.medinfo.sms.processor;

import javax.servlet.http.HttpServletRequest;

public interface SMSRequestProcessor {

    public String getPincode(HttpServletRequest httpServletRequest);
}
