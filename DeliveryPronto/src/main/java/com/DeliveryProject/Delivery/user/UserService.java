package com.DeliveryProject.Delivery.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DeliveryProject.Delivery.exceptions.ClientNotFoundException;
import com.DeliveryProject.Delivery.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public List<UserEntity> list() {
		return userRepository.findAll();
	}

	public UserEntity create(UserEntity user) {
		return userRepository.save(user);
	}

	public UserEntity findById(Long id) throws ClientNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Usuario não foi encontrato em nosso banco de dados"));
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		}

}
