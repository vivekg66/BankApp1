package com.example.BankApp.Repository;

import com.example.BankApp.Entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<CustomerDetails,Long>{
}
