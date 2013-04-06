package com.thoughtworks.medinfo.web;

import com.thoughtworks.medinfo.model.HCPRole;
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
    HCPRole hcpRole;

    @RequestMapping(method = RequestMethod.GET)
    public void get(Model model, @ModelAttribute HCProviderCommand hcpCommand) {
        model.addAttribute("hcpGrid", hcpService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(Model model, @Valid HCProviderCommand hcpCommand, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("hcpGrid", hcpService.findAll());
            model.addAttribute("hcpRoles", hcpRole.getRoles());
            return URL;
        }
        hcpService.save(hcpCommand);
        return "redirect:" + URL;
    }

    @RequestMapping(method = RequestMethod.POST, params = "update=Update all enabled items")
    public String updateItem(Model model, @Valid HCPGrid hcpGrid, BindingResult result) {
        if (result.hasErrors()) {
            hcpService.viewAll(hcpGrid);
            return URL;
        }
        hcpService.saveAll(hcpGrid);
        return "redirect:" + URL;
    }

    @RequestMapping(method = RequestMethod.POST, params = "delete=Delete all enabled items")
    public String deleteItem(Model model, @Valid HCPGrid hcpGrid, BindingResult result) {
        if (result.hasErrors()) {
            hcpService.viewAll(hcpGrid);
            return URL;
        }
        hcpService.deleteAll(hcpGrid);
        return "redirect:" + URL;
    }

}
