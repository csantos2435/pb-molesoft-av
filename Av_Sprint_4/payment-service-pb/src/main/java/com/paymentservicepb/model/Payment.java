package com.paymentservicepb.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.paymentservicepb.model.enums.Currency;
import com.paymentservicepb.model.enums.PaymentType;
import com.paymentservicepb.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", updatable = false, unique = true)
	private UUID payment_id;
	
	@Column(unique = true)
	private String seller_id;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="payment")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private PaymentType payment_type;
	
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
	@Positive
	private BigDecimal transaction_amount;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="payment")
	private Card card;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	private LocalDateTime received_at = LocalDateTime.now();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="payment")
	private Authorization authorization;

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void setReceived_at(LocalDateTime received_at) {
        this.received_at = received_at;
    }

    public Authorization getAuthorization() {
        return new Authorization();
    }
}
