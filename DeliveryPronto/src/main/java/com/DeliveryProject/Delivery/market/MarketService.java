package com.DeliveryProject.Delivery.market;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DeliveryProject.Delivery.dto.MarketDto;
import com.DeliveryProject.Delivery.exceptions.ClientNotFoundException;
import com.DeliveryProject.Delivery.exceptions.MarketNotFoundException;
import com.DeliveryProject.Delivery.product.ProductEntity;
import com.DeliveryProject.Delivery.product.ProductService;
import com.DeliveryProject.Delivery.repository.MarketRepository;
import com.DeliveryProject.Delivery.user.UserEntity;
import com.DeliveryProject.Delivery.user.UserService;

import lombok.RequiredArgsConstructor;

//classe que faz o registro definitivo dos itens no carrinho de compras
@Service
@RequiredArgsConstructor
public class MarketService {

	private final MarketRepository marketRepository;
	private final UserService userService;
	private final ProductService productService;

	public List<MarketEntity> list() {
		return marketRepository.findAll();
	}

	public MarketEntity create(MarketDto dto) throws ClientNotFoundException {
		UserEntity user = userService.findById(dto.getUserId());

		MarketEntity market = MarketEntity.builder()
				.user(user)
				.status(MarketStatus.PENDING)
				.build();
		
		List<ItemEntity> items = dto.getProducts().stream()
				.map(item -> {
			try {
				ProductEntity product = productService.findById(item.getProductId());
				return ItemEntity.builder()
						.market(market)
						.product(product.getDescription())
						.price(product.getPrice())
						.quantity(item.getQuantity())
						.build();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
		
		double total = items.stream().filter(item -> item.getQuantity() > 0).mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
		market.setTotal(total);
		market.setItems(items);
		
		return marketRepository.save(market);

	}
	public MarketEntity findById(Long id) throws MarketNotFoundException {
		return marketRepository.findById(id).orElseThrow(() -> new MarketNotFoundException("Cesta de mercado não foi encontrada em nosso banco de dados"));
	}

	
}
