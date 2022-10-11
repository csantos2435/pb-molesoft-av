package com.paymentservicepb.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.paymentservicepb.model.Authorization;
import com.paymentservicepb.model.Card;
import com.paymentservicepb.model.Customer;
import com.paymentservicepb.model.enums.Currency;
import com.paymentservicepb.model.enums.PaymentType;
import com.paymentservicepb.model.enums.Status;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    
    private Long id;
    private UUID payment_id;
    private String seller_id;
    private Customer customer;
    private PaymentType payment_type;
    private Currency currency;
    private BigDecimal transaction_amount;
    private Card card;
    private Status status;
    private LocalDateTime received_at;
    private Authorization authorization;
    
    public Long getId() {
        return id;
    }
}
