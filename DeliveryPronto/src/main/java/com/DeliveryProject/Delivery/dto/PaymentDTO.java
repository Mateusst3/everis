package com.DeliveryProject.Delivery.dto;


import com.DeliveryProject.Delivery.payment.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO {

    private Long marketId;
    private PaymentType paymentType;


}
