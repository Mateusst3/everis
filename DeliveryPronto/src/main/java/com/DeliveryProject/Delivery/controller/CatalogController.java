package com.DeliveryProject.Delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

	// classe responsável por registrar o index ao localhost:9090/catalog
	@GetMapping("/catalog")
	public String getPostNew() {
		return "index";
	}
}
