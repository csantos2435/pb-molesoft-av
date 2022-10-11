package com.paymentservicepb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.paymentservicepb.model.enums.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotNull @NotEmpty
	private String number_token;
	
	@NotNull @NotEmpty
	private String cardholder_name;
	
	@NotNull @NotEmpty
	@Column(unique = true)
	@Size(min = 3, max = 3)
	private Integer security_code;
	
	@NotNull @NotEmpty
	@Enumerated(EnumType.STRING)
	private Brand brand;
	
	@NotNull @NotEmpty
	@DateTimeFormat(pattern = "MM")
	private LocalDate expiration_month;
	
	@NotNull @NotEmpty
	@DateTimeFormat(pattern = "yy")
	private LocalDate expiration_year;
	
    @OneToOne(optional=false)
        private Payment payment;
}
