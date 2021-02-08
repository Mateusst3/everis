package com.DeliveryProject.Delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeliveryProject.Delivery.exceptions.MarketNotFoundException;
import com.DeliveryProject.Delivery.payment.PaymentEntity;
import com.DeliveryProject.Delivery.payment.PaymentService;

import lombok.RequiredArgsConstructor;

//Classe responsável pelo registro do pagamento no banco de dados, tanto para getar os carrinhos cadastrados, quanto para
//cadastrar novos
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	@GetMapping
	public List<PaymentEntity> list() {
		return paymentService.list();
	}

	@PostMapping
	public PaymentEntity create(@RequestBody PaymentEntity payment) throws MarketNotFoundException {
		return paymentService.create(payment);
	}

}
