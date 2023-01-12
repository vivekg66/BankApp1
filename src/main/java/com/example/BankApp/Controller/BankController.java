package com.example.BankApp.Controller;

import com.example.BankApp.Entity.CustomerDetails;
import com.example.BankApp.Repository.BankRepo;
import com.example.BankApp.Response.ResponseMapper;
import com.example.BankApp.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BankController {

    @Autowired
    private BankService bankService;


    @GetMapping("/customers/{id}")
    ResponseEntity<ResponseMapper> getCustomerById(@PathVariable("id") long id) {
        ResponseMapper responseMapper = bankService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseMapper);
    }

    @GetMapping("/customers")
    List<CustomerDetails> getAllCustomers() {
        List<CustomerDetails> customerDetailsList = bankService.getCustomerList();
        return customerDetailsList;
    }


}
