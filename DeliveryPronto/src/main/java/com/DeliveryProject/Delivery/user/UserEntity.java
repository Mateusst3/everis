package com.DeliveryProject.Delivery.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.DeliveryProject.Delivery.address.AddressEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "number")
	private String number;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_address")
	private AddressEntity address;

}
