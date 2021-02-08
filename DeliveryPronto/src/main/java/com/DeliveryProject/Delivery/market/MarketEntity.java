package com.DeliveryProject.Delivery.market;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.DeliveryProject.Delivery.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Classe responsável por "registrar" os itens no carrinho de compra
@Entity
@Table(name = "market")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "total")
	private double total;

	@Column(name = "product")
	private String product;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private MarketStatus status;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "market", cascade = CascadeType.PERSIST)
	private List<ItemEntity> items;

}
