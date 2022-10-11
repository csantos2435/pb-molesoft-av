package com.paymentservicepb.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.paymentservicepb.model.enums.ReasonMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authorizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorization {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorization_code;
	
	@NotNull 
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime authorized_at = LocalDateTime.now();
	
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reason_code;
	
	@Enumerated(EnumType.STRING)
	private ReasonMessage reason_message;
	
	@OneToOne(optional=false)
    private Payment payment;
	
	public void setAuthorized_at(LocalDateTime authorized_at) {
        this.authorized_at =  authorized_at;
    }
	
	public void setReason_message(ReasonMessage reason_message) {
        this.reason_message = reason_message;
    }
}
