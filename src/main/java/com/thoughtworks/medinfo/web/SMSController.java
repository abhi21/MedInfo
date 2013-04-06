package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.sms.processor.SMSRequestProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SMSController {

    private SMSRequestProcessor smsRequestProcessor;

    private SMSController() {
    }

    public SMSController(@Qualifier("exotelSMSRequestProcessor") SMSRequestProcessor smsRequestProcessor) {
        this.smsRequestProcessor = smsRequestProcessor;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public void reply(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {

    }
}
