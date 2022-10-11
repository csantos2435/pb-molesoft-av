package com.paymentservicepb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentservicepb.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
