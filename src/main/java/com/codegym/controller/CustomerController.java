package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String index(Model model) {
        Iterable<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);

        model.addAttribute("numbers","no");
        return "list";
    }
    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/customer/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/list";
    }
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer) {
        customerService.update(customer);
        return "redirect:/list";
    }
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable Long id, Model model,RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/list";
    }
    @PostMapping("customer/search")
    public String search(@RequestParam String search,Model model){
        model.addAttribute("customers", customerService.searchByName(search));
        return "list";
    }
}
