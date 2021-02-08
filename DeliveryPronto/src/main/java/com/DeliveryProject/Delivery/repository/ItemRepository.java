package com.DeliveryProject.Delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeliveryProject.Delivery.market.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
