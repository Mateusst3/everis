package com.DeliveryProject.Delivery.payment;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.DeliveryProject.Delivery.market.MarketEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private LocalDateTime date;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private PaymentType type;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="market_id")
	private MarketEntity market;
}

