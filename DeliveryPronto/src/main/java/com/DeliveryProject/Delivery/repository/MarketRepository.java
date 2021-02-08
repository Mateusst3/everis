package com.DeliveryProject.Delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeliveryProject.Delivery.market.MarketEntity;

@Repository
public interface MarketRepository extends JpaRepository<MarketEntity, Long> {
}
