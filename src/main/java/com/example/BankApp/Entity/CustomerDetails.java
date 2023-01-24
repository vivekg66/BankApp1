//vivek
package com.example.BankApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customerdetails")
public class CustomerDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerid;
    private String customerName;
    private String customerEmail;
    private long customermobileno;

    @Transient
    private List<Address>addresses= new ArrayList<>();





}
