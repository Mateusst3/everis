package com.DeliveryProject.Delivery.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketDto {

	private Long userId;
	private List<ItemDto> products;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ItemDto> getProducts() {
		return products;
	}

	public void setProducts(List<ItemDto> products) {
		this.products = products;
	}


}
