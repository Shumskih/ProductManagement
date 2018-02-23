package org.shumskih.spring.controller;

import org.shumskih.spring.model.Manufacturer;
import org.shumskih.spring.model.Product;
import org.shumskih.spring.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@SessionAttributes("manufacturers")
public class ProductController {

    private GenericService<Product, UUID> productService;

    private GenericService<Manufacturer, UUID> manufacturerService;

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(GenericService<Product, UUID> productService) {
        this.productService = productService;
    }

    @Autowired(required = true)
    @Qualifier(value = "manufacturerService")
    public void setManufacturerService(GenericService<Manufacturer, UUID> manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listOfProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listOfProducts", this.productService.getAll());

        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if(product.getId() == null) {
            this.productService.add(product);
        } else {
            this.productService.update(product);
        }

        return "redirect:/products";
    }

    @RequestMapping("/products/remove/{id}")
    public String removeProduct(@PathVariable("id") UUID id) {
        this.productService.remove(id);

        return "redirect:/products";
    }

    @RequestMapping("products/edit/{id}")
    public String editProduct(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("product", this.productService.getById(id));
        model.addAttribute("listOfProducts", this.productService.getAll());

        return "products";
    }

    @RequestMapping("product-data/{id}")
    public String productData(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("product", this.productService.getById(id));

        return "product-data";
    }

    @ModelAttribute("manufacturers")
    public List<Manufacturer> listOfManufacturers() {
        return manufacturerService.getAll();
    }
}
