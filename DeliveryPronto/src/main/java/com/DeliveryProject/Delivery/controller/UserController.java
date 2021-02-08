package com.DeliveryProject.Delivery.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeliveryProject.Delivery.user.UserEntity;
import com.DeliveryProject.Delivery.user.UserService;

import lombok.RequiredArgsConstructor;


//Classe responsável pelo controle de usuários no banco de dados, tanto para getar os carrinhos cadastrados, quanto para
//cadastrar novos, além de poder excluir usuários cadastrados
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	@GetMapping
	public List<UserEntity> list(){
		return userService.list();
	}
	@PostMapping
	public UserEntity create(@RequestBody UserEntity user) {
		return userService.create(user);
	}
	
	@DeleteMapping(path= "/{id}")
	
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	 
}
