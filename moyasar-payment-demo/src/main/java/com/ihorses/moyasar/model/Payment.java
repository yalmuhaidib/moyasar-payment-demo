package com.ihorses.moyasar.model;

import static com.ihorses.moyasar.Constants.MOYASAR_DATE_PATTERN_STR;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

	/*
	 * "id": "983a613d-6e8a-4280-9069-4b2894e36fb4",
            "status": "failed",
            "amount": 1000,
            "fee": 0,
            "currency": "SAR",
            "refunded": 0,
            "refunded_at": null,
            "captured": 0,
            "captured_at": null,
            "voided_at": null,
            "description": null,
            "amount_format": "10.00 SAR",
            "fee_format": "0.00 SAR",
            "refunded_format": "0.00 SAR",
            "captured_format": "0.00 SAR",
            "invoice_id": null,
            "ip": null,
            "callback_url": "https://ihorses.net/",
            "created_at": "2020-07-16T11:41:44.715Z",
            "updated_at": "2020-07-16T11:56:49.523Z",
	 */
	private String id;
	private String status;
	private Double amount;
	private Double fee;
	private String currency;
	private String refunded;
	@JsonProperty("refunded_at")
	@JsonFormat(pattern = MOYASAR_DATE_PATTERN_STR)
	private LocalDateTime refundDate;
	private String captured;
	@JsonProperty("captured_at")
	@JsonFormat(pattern = MOYASAR_DATE_PATTERN_STR)
	private LocalDateTime captureDate;
	private String description;
	private String amount_format;
	private String fee_format;
	private String refunded_format;
	private String captured_format;
	private String invoice_id;
	private String ip;
	private String callback_url;
	@JsonProperty("created_at")
	@JsonFormat(pattern = MOYASAR_DATE_PATTERN_STR)
	private LocalDateTime createDate;
	@JsonProperty("updated_at")
	@JsonFormat(pattern = MOYASAR_DATE_PATTERN_STR)
	private LocalDateTime updateDate;
	private PaymentSource source;
}
