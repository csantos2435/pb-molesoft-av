package com.paymentservicepb.dto;

import com.paymentservicepb.model.enums.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private DocumentType document_type;
    private String document_number;
}
