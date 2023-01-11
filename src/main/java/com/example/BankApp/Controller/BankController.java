package com.example.BankApp.Controller;

import com.example.BankApp.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BankController {

    @Autowired
    private BankService bankService;

    public BankController(BankService bankService){
        super();
        this.bankService = bankService;
    }

    @GetMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers",bankService.getAllCustomers());
        return "success";
    }


}
