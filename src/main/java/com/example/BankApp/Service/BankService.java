package com.example.BankApp.Service;

import com.example.BankApp.Entity.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAllCustomers();

    Bank saveCustomer(Bank bank);

    Bank getCustomerById(Long id);

    Bank  updateCustomer(Bank bank);

    void deleteCustomerById(Long id);
}
