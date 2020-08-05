package com.ihorses.moyasar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentSource {

	/*
	 * "source": {
                "type": "creditcard",
                "company": "visa",
                "name": "hussein abdelaziz",
                "number": "XXXX-XXXX-XXXX-1111",
                "message": "Allowed time frame for transaction has been expired.",
                "transaction_url": "https://api.moyasar.com/v1/transaction_auths/482d7b2e-bfe8-4e9d-bb4c-fdd207dcefca/form?token=auth_iqwa1z6hpnkEsowPQLhQeNqixLQRyb8xynRFBs21bU6"
            }
	 */
	
	private String type;
	private String company;
	private String name;
	private String number;
	private String message;
}
