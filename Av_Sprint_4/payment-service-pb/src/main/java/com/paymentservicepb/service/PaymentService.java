package com.paymentservicepb.service;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paymentservicepb.dto.PaymentDto;
import com.paymentservicepb.dto.PaymentReturnDto;
import com.paymentservicepb.dto.PaymentSaveDto;
import com.paymentservicepb.model.Payment;
import com.paymentservicepb.model.enums.ReasonMessage;
import com.paymentservicepb.model.enums.Status;
import com.paymentservicepb.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;

    public PaymentService() {
    }


    public Page<PaymentSaveDto> getAll(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PaymentSaveDto.class));
    }

    public PaymentSaveDto getById(Long id) {
        Payment payment = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(payment, PaymentSaveDto.class);
    }

    public PaymentReturnDto post(PaymentDto dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        
        payment.setStatus(Status.APPROVED);
        payment.setReceived_at(LocalDateTime.now());
        payment.getAuthorization().setAuthorized_at(LocalDateTime.now());
        payment.getAuthorization().setReason_message(ReasonMessage.TRANSACTION_APPROVED);;
        
        repository.save(payment);

        return modelMapper.map(payment, PaymentReturnDto.class);
    }
}
