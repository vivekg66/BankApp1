package com.example.BankApp.Service.Impl;

import com.example.BankApp.Entity.Bank;
import com.example.BankApp.Repository.BankRepo;
import com.example.BankApp.Service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private BankRepo bankRepo;
    public BankServiceImpl(BankRepo bankRepo) {
        super();
        this.bankRepo = bankRepo;
    }


    @Override
    public List<Bank> getAllCustomers() {
        return bankRepo.findAll();
    }

    @Override
    public Bank saveCustomer(Bank bank) {
        return bankRepo.save(bank);
    }

    @Override
    public Bank getCustomerById(Long id) {
        return bankRepo.findById(id).get();
    }

    @Override
    public Bank updateCustomer(Bank bank) {
        return bankRepo.save(bank);
    }

    @Override
    public void deleteCustomerById(Long id) {
        bankRepo.deleteById(id);

    }
}
