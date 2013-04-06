package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.service.HCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    HCPService hcpService;

	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
        model.addAttribute("hcpGrid", hcpService.findAll());
        return "home";
	}
	
}

