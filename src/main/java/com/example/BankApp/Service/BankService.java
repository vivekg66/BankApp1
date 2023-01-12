package com.example.BankApp.Service;

import com.example.BankApp.Entity.CustomerDetails;
import com.example.BankApp.Repository.BankRepo;
import com.example.BankApp.Response.ResponseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseMapper getCustomerById(long id) {
        CustomerDetails customerDetails = bankRepo.findById(id).get();
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
        ResponseMapper responseMapper = new ResponseMapper();
        List<CustomerDetails> customerDetailsList = bankRepo.findAll();
        return customerDetailsList;
    }


}
