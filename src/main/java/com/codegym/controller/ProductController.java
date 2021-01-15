package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public String getViewList(Model model){
        Iterable<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "product/list";
    }

    @GetMapping(value ="/products/create")
    public  String create(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }
    @PostMapping(value="products/create")
    public String save(Product product){
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping(value = "products/edit/{id}")
    public String editView(@PathVariable("id")Long id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/edit";
    }
    @PostMapping(value = "products/edit")
    public String editProduct(Product product, RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "Edit product successfully!");

        return "redirect:/products";
    }
}
