package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.HCProvider;
import com.thoughtworks.medinfo.service.HCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private HCPService hcpService;

    private HomeController() {
    }

    @Autowired
    public HomeController(HCPService hcpService) {
        this.hcpService = hcpService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("hcpGrid", hcpService.findAll());
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value= "/search/{pincode}")
    @ResponseBody
    public String getNearestHCPs(@PathVariable("pincode") String pincode, HttpServletResponse httpServletResponse, Model model) {
        httpServletResponse.setContentType("text/html");
        List<HCProvider> hcProviders = hcpService.findByPincode(pincode);
        model.addAttribute("hcpGrid", hcProviders);
        return "home";
    }
}

