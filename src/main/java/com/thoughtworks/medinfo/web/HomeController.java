package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.HCProvider;
import com.thoughtworks.medinfo.service.HCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

    public static final int NO_LIMIT = Integer.MAX_VALUE;
    private HCPService hcpService;

    private HomeController() {
    }

    @Autowired
    public HomeController(HCPService hcpService) {
        this.hcpService = hcpService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("hcpGrid", hcpService.findAll());
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "search")
    public String getNearestHCPs(@RequestParam String pincode, HttpServletResponse httpServletResponse, Model model) {
        httpServletResponse.setContentType("text/html");
        List<HCProvider> hcProviders = hcpService.findByPincode(pincode, NO_LIMIT);
        model.addAttribute("hcpGrid", new HCPGrid(hcProviders));
        model.addAttribute("searchStat", "Number of Records for " + pincode);
        model.addAttribute("searchCount", hcProviders.size());
        return "home";
    }
}

