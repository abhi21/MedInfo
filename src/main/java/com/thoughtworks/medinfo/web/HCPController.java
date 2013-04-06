package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.service.HCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(HCPController.URL)
public class HCPController {

	static final String URL = "/hcproviders";
	
	@Autowired
    HCPService hcpService;

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model, @ModelAttribute HCProviderCommand hcpCommand) {
		model.addAttribute("hcpGrid", hcpService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model, @Valid HCProviderCommand hcpCommand, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("hcpGrid", hcpService.findAll());
			return URL;
		}
		hcpService.save(hcpCommand);
		return "redirect:" + URL;
	}
	
	@RequestMapping(method = RequestMethod.POST, params="_method=put")
	public String put(Model model, @Valid HCPGrid hcpGrid, BindingResult result) {
		if (result.hasErrors()) {
			hcpService.updateWithAll(hcpGrid);
			return URL;
		}
		hcpService.saveAll(hcpGrid);
		return "redirect:" + URL;
	}
	
}
