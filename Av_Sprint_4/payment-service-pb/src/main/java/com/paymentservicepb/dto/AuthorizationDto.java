package com.paymentservicepb.dto;

import java.time.LocalDateTime;

import com.paymentservicepb.model.enums.ReasonMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationDto {

    private Long authorization_code;
    private LocalDateTime authorized_at;
    private Long reason_code;
    private ReasonMessage reason_message;
    
    public void setAuthorized_at(LocalDateTime authorized_at) {
        this.authorized_at = authorized_at;
    }
    
    public void setReason_message(ReasonMessage reason_message) {
        this.reason_message = reason_message;
    }
}
