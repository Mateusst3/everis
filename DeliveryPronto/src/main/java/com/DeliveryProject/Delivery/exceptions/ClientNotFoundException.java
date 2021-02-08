package com.DeliveryProject.Delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClientNotFoundException(String msg) {
		super(msg);
	}
}
