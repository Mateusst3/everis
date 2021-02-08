package com.DeliveryProject.Delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

		public static final long SerialVersionUID = 1L;
		
		public ProductNotFoundException(String msg) {
		super(msg);
		}
}
