package com.DeliveryProject.Delivery.payment;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

import com.DeliveryProject.Delivery.dto.PaymentDTO;
import lombok.Getter;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DeliveryProject.Delivery.exceptions.MarketNotFoundException;
import com.DeliveryProject.Delivery.market.MarketEntity;
import com.DeliveryProject.Delivery.market.MarketService;
import com.DeliveryProject.Delivery.market.MarketStatus;
import com.DeliveryProject.Delivery.repository.PaymentRepository;
import org.apache.commons.codec.binary.Base32;
import de.taimos.totp.TOTP;


import lombok.RequiredArgsConstructor;

@Service
@Getter
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private MarketService marketService;
	private String paySecret;

	PaymentService(){
		this.paySecret = generateSecretKey();
	}


	public List<PaymentEntity> list() {
		return paymentRepository.findAll();
	}

	public PaymentEntity create(PaymentDTO paymentDTOParam) throws MarketNotFoundException {
		MarketEntity market = marketService.findById(paymentDTOParam.getMarketId());
		market.setStatus(MarketStatus.COMPLETED);
		PaymentEntity payment = new PaymentEntity();
		payment.setType(paymentDTOParam.getPaymentType());
		payment.setDate(LocalDateTime.now());
		payment.setMarket(market);


		return paymentRepository.save(payment);
	}


	public static String generateSecretKey() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);
		Base32 base32 = new Base32();
		return base32.encodeToString(bytes);
	}

	public static String getTOTPCode(String secretKey) {
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(secretKey);
		String hexKey = Hex.encodeHexString(bytes);
		return TOTP.getOTP(hexKey);

	}

//	public static String getGoogleAuthenticatorBarCode(String secretKey, String account, String issuer) {
//		try {
//			return "otpauth://totp/"
//					+ URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
//					+ "?secret=" + URLEncoder.encode(secretKey, "UTF-8").replace("+", "%20")
//					+ "&issuer=" + URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
//		} catch (UnsupportedEncodingException e) {
//			throw new IllegalStateException(e);
//		}
//	}

	public String doPaymentAuth(){
		return getTOTPCode(this.paySecret);
	}

	public boolean validate2fa(String code){
		return code.equals(getTOTPCode(this.getPaySecret()));
	}

}
