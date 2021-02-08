package com.DeliveryProject.Delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeliveryProject.Delivery.product.ProductEntity;
import com.DeliveryProject.Delivery.product.ProductService;

import lombok.RequiredArgsConstructor;

//Classe responsável por pegar os produtos cadastrados no banco de dados, são cadastrados através do data.sql
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping
	public List<ProductEntity> list(){
		return productService.list();
	}
	
	

	
	
	
}
