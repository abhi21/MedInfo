package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.HCProvider;
import com.thoughtworks.medinfo.service.HCPService;
import com.thoughtworks.medinfo.sms.processor.SMSRequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private HCPService hcpService;
    private SMSRequestProcessor smsRequestProcessor;

    private HomeController() {
    }

    @Autowired
    public HomeController(HCPService hcpService, @Qualifier("exotelSMSRequestProcessor")
    SMSRequestProcessor smsRequestProcessor) {
        this.hcpService = hcpService;
        this.smsRequestProcessor = smsRequestProcessor;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("hcpGrid", hcpService.findAll());
        return "home";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public void reply(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("text/plain");
        List<HCProvider> hcProviders = hcpService.findByPincode(smsRequestProcessor.getPincode(httpServletRequest));
        String toSend = pretify(hcProviders);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(toSend.getBytes());
        outputStream.flush();
    }

    private String pretify(List<HCProvider> hcProviders) {
        if (hcProviders.size() == 0) {
            return "Sorry no matches found";
        } else {
            String result = "";
            for (int i = 0; i < hcProviders.size(); i++) {
                HCProvider hcProvider = hcProviders.get(i);
                result += i + ". name:" + hcProvider.getName() + "(" + hcProvider.getRole() + ") " +
                        "ph:" + hcProvider.getPhone() + " " +
                        "address:" + hcProvider.getStreet() + ", " + hcProvider.getCity() + " ";
            }
            return result;
        }
    }
}

