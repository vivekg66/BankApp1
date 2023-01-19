package com.example.BankApp.Service;

import com.example.BankApp.Entity.CustomerDetails;
import com.example.BankApp.Repository.BankRepo;
import com.example.BankApp.Response.ResponseMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(BankService.class);

    public ResponseMapper getCustomerById(long customerId) {
        CustomerDetails customerDetails = bankRepo.findById(customerId).get();
        //http://localhost:8081/api/address/2
       ArrayList forObject = restTemplate.getForObject("http://localhost:8081/api/address/2", ArrayList.class);
       logger.info("",forObject);


        ResponseMapper responseMapper = modelMapper.map(customerDetails, ResponseMapper.class);
        //USing modelmapper instead of manually converting the entity object to response mapper
//        ResponseMapper responseMapper = new ResponseMapper();
//        responseMapper.setId(customerDetails.getId());
//        responseMapper.setCustomerName(customerDetails.getCustomerName());
//        responseMapper.setCustomerEmail(customerDetails.getCustomerEmail());
//        responseMapper.setCustomerMobileNum(customerDetails.getCustomerMobileNum());
        return responseMapper;
    }

    public List<CustomerDetails> getCustomerList() {
        List<CustomerDetails> customerDetailsList = bankRepo.findAll();
        return customerDetailsList;
    }

    public ResponseMapper addNewCustomer(CustomerDetails customerDetails){
      CustomerDetails customerDetails1 = bankRepo.save(customerDetails);
      ResponseMapper responseMapper= modelMapper.map(customerDetails1,ResponseMapper.class);
      return responseMapper;
    }

    public CustomerDetails updateCustomerById(long id ,CustomerDetails customerDetails){
        CustomerDetails customerDetails1=bankRepo.findById(id).get();
        customerDetails1.setCustomerName(customerDetails1.getCustomerName());
        customerDetails1.setCustomerEmail(customerDetails1.getCustomerEmail());
        customerDetails1.setCustomermobileno(customerDetails1.getCustomermobileno());

        return bankRepo.save(customerDetails1);
    }

    public void deleteCustomerById(long id) {
        bankRepo.deleteById(id);
    }



}
