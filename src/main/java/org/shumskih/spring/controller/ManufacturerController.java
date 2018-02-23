package org.shumskih.spring.controller;

import org.shumskih.spring.model.Manufacturer;
import org.shumskih.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public class ManufacturerController {
    private GenericService<Manufacturer, UUID> manufacturerService;

    @Autowired(required = true)
    @Qualifier(value = "manufacturerService")
    public void setProductService(GenericService<Manufacturer, UUID> manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(value = "manufacturers", method = RequestMethod.GET)
    public String listOfManufacturers(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        model.addAttribute("listOfManufacturers", this.manufacturerService.getAll());

        return "manufacturers";
    }

    @RequestMapping(value = "/manufacturers/add", method = RequestMethod.POST)
    public String addManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        if(manufacturer.getId() == null) {
            this.manufacturerService.add(manufacturer);
        } else {
            this.manufacturerService.update(manufacturer);
        }

        return "redirect:/manufacturers";
    }

    @RequestMapping("/manufacturers/remove/{id}")
    public String removeManufacturer(@PathVariable("id") UUID id) {
        this.manufacturerService.remove(id);

        return "redirect:/manufacturers";
    }

    @RequestMapping("manufacturers/edit/{id}")
    public String editManufacturer(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("manufacturer", this.manufacturerService.getById(id));
        model.addAttribute("listOfManufacturers", this.manufacturerService.getAll());

        return "manufacturers";
    }

    @RequestMapping("manufacturer-data/{id}")
    public String manufacturerData(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("manufacturer", this.manufacturerService.getById(id));

        return "manufacturer-data";
    }
}