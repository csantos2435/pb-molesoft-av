package com.paymentservicepb.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import com.paymentservicepb.model.Authorization;
import com.paymentservicepb.model.enums.Currency;
import com.paymentservicepb.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentReturnDto {

    private Long id;
    private UUID payment_id;
    private String seller_id;
    private BigDecimal transaction_amount;
    private Currency currency;
    private Status status;
    private LocalDateTime received_at;
    private Authorization authorization;
    
    public Long getId() {
        return id;
    }
}
