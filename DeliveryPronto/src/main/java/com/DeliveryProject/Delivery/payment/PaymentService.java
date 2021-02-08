package com.DeliveryProject.Delivery.payment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DeliveryProject.Delivery.exceptions.MarketNotFoundException;
import com.DeliveryProject.Delivery.market.MarketEntity;
import com.DeliveryProject.Delivery.market.MarketService;
import com.DeliveryProject.Delivery.market.MarketStatus;
import com.DeliveryProject.Delivery.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	private final MarketService marketService;
	

	public List<PaymentEntity> list() {
		return paymentRepository.findAll();
	}

	public PaymentEntity create(PaymentEntity payment) throws MarketNotFoundException {
		MarketEntity market = marketService.findById(payment.getMarket().getId());
		market.setStatus(MarketStatus.COMPLETED);
		
		payment.setDate(LocalDateTime.now());
		payment.setMarket(market);
		
		
		return paymentRepository.save(payment);
	}
	



}
