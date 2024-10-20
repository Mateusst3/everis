package com.DeliveryProject.Delivery.controller;

import java.util.List;

import com.DeliveryProject.Delivery.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DeliveryProject.Delivery.exceptions.MarketNotFoundException;
import com.DeliveryProject.Delivery.payment.PaymentEntity;
import com.DeliveryProject.Delivery.payment.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	@Autowired
	private final PaymentService paymentService;

	@GetMapping
	public List<PaymentEntity> list() {
		return paymentService.list();
	}

	@PostMapping
	public PaymentEntity create(@RequestBody PaymentDTO payment) throws MarketNotFoundException {
		return paymentService.create(payment);
	}

	@PostMapping("/payAuth")
	public ResponseEntity<?> doPayAuth(){
		return ResponseEntity.ok().body(paymentService.doPaymentAuth());
	}

	@PostMapping("/validate2fa")
	public ResponseEntity<?> validate2Fa(@RequestParam String code){
		return ResponseEntity.ok().body(paymentService.validate2fa(code));
	}

}
