package com.DeliveryProject.Delivery.market;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//classe responsável por "transformar" os produtos em itens, fazendo com que um produto se "transforme" em item contendo Id,
//preço, descrição e a quantidade que estará no carrinho
@Entity
@Table(name= "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "products")
	private String product;
	
	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "market_id")
	@JsonIgnore
	private MarketEntity market;
	
}
