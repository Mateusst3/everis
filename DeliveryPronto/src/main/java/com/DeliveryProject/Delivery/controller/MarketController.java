package com.DeliveryProject.Delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeliveryProject.Delivery.dto.MarketDto;
import com.DeliveryProject.Delivery.exceptions.ClientNotFoundException;
import com.DeliveryProject.Delivery.market.MarketEntity;
import com.DeliveryProject.Delivery.market.MarketService;
import lombok.RequiredArgsConstructor;


//Classe responsável pelo "carrinho de compras" no banco de dados, tanto para getar os carrinhos cadastrados, quanto para
//cadastrar novos
@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor
public class MarketController {

	private final MarketService marketService;

	@GetMapping
	public List<MarketEntity> list() {
		return marketService.list();
	}

	@PostMapping
	public MarketEntity create(@RequestBody MarketDto dto) throws ClientNotFoundException {
		return marketService.create(dto);
	}

	
}
