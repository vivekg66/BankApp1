package com.example.BankApp.Controller;

import com.example.BankApp.Entity.CustomerDetails;
import com.example.BankApp.Repository.BankRepo;
import com.example.BankApp.Response.ResponseMapper;
import com.example.BankApp.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BankController {

    @Autowired
    private BankService bankService;


    @GetMapping("/customer/{customerId}")
    ResponseEntity<ResponseMapper> getCustomerById(@PathVariable("customerId") long customerId) {
        ResponseMapper responseMapper = bankService.getCustomerById(customerId);
        //http://localhost:8081/api/address/2
        return ResponseEntity.status(HttpStatus.OK).body(responseMapper);
    }

    @GetMapping("/customers")
    List<CustomerDetails> getAllCustomers(@RequestParam(name = "customerName") String customerName) {
        List<CustomerDetails> customerDetailsList = bankService.getCustomerList();
        return customerDetailsList;
    }


    @PostMapping("/new/customer")
    ResponseEntity<ResponseMapper> createNewCustomer(@RequestBody CustomerDetails customerDetails) {
        ResponseMapper responseMapper = bankService.addNewCustomer(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMapper);

    }

    @DeleteMapping("/customer/delete/{id}")
    public String deleteCustomerById(@PathVariable("id") long id) {
        bankService.deleteCustomerById(id);
        return "Customer deleted with id " + id;
    }

    @PatchMapping("/customer/update/{id}")
    CustomerDetails updateCustomerById(@RequestBody CustomerDetails customerDetails, @PathVariable(value = "id") long id) {
       CustomerDetails customerDetails1= bankService.updateCustomerById(id, customerDetails);
       customerDetails1.setCustomerName(customerDetails1.getCustomerName());
       customerDetails1.setCustomerEmail(customerDetails1.getCustomerEmail());
       customerDetails1.setCustomermobileno(customerDetails1.getCustomermobileno());
        return customerDetails1;
    }


}
