package com.policy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private CurrentAddress currentAddress;
	private AdditionalAddress additionalAddress;
	
}
