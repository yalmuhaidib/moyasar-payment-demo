package com.ihorses.moyasar.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentList {

	private List<Payment> payments;
}
