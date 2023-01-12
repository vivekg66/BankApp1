package com.example.BankApp.Response;

import lombok.Data;

@Data
public class ResponseMapper {
    private long id;
    private String customerName;
    private String customerEmail;
    private long customerMobileNum;

}
