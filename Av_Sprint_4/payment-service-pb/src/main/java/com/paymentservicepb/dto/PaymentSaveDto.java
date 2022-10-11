package com.paymentservicepb.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.paymentservicepb.model.Authorization;
import com.paymentservicepb.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSaveDto {

    private Long id;
    private UUID payment_id;
    private BigDecimal transaction_amount;
    private Status status;
    private Authorization authorization;
    
    public Long getId() {
        return id;
    }
}
