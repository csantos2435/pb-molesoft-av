package com.paymentservicepb.dto;

import java.time.LocalDate;

import com.paymentservicepb.model.enums.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    
    private String number_token;
    private String cardholder_name;
    private Integer security_code;
    private Brand brand;
    private LocalDate expiration_month;
    private LocalDate expiration_year;


}
