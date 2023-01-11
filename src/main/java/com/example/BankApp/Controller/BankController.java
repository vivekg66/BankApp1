package com.example.BankApp.Controller;

import com.example.BankApp.Entity.Bank;
import com.example.BankApp.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BankController {

    @Autowired
    private BankService bankService;


    @GetMapping("/customers")
    public List<Bank> getCustomers( ){
       return bankService.getAllCustomers();
    }


}
