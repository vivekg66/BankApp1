package com.example.BankApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int addressId;
    private int customerId;
    private int accountId;
    private int houseno;
    private String streetName;
    private String city;
}
