package com.DeliveryProject.Delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeliveryProject.Delivery.user.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	

}
