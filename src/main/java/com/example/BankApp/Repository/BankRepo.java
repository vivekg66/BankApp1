package com.example.BankApp.Repository;

import com.example.BankApp.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Long>{
}
