package com.DeliveryProject.Delivery.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DeliveryProject.Delivery.exceptions.ProductNotFoundException;
import com.DeliveryProject.Delivery.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public List<ProductEntity> list(){
		return productRepository.findAll();
	}
	
	public ProductEntity create (ProductEntity product) {
		return productRepository.save(product);
	}
	
	public ProductEntity findById(long id) throws ProductNotFoundException{
		return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("produto não encontrado"));
	}
}
