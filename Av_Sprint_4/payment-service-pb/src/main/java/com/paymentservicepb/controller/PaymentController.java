package com.paymentservicepb.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.paymentservicepb.dto.PaymentDto;
import com.paymentservicepb.dto.PaymentReturnDto;
import com.paymentservicepb.dto.PaymentSaveDto;
import com.paymentservicepb.service.PaymentService;

@RestController
@RequestMapping("/api/v1/order/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService service;
    
    @GetMapping
    public Page<PaymentSaveDto> findAll(@PageableDefault(size = 10) Pageable paginacao) {
        return service.getAll(paginacao);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentSaveDto> findById(@PathVariable @NotNull Long id) {
        PaymentSaveDto dto = service.getById(id);

        return  ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<PaymentReturnDto> postRequest(@RequestBody @Valid PaymentDto dto, UriComponentsBuilder uriBuilder) {
        PaymentReturnDto orderMade = service.post(dto);

        URI address = uriBuilder.path("/api/v1/order/payment/{orderId}").buildAndExpand(orderMade.getId()).toUri();

        return ResponseEntity.created(address).body(orderMade);

    }

}
