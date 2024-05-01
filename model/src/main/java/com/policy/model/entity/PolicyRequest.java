package com.policy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyRequest {
	
	@NotBlank(message = "product Id shouldn't be NULL OR EMPTY")
    private String productId;
	
	
	
	@NotBlank(message = "CustomerNationality Should not  be NULL OR EMPTY")
    private String customerNationality;
	@NotBlank(message = "Employment type shouldn't be NULL OR EMPTY")
    private  String employmentType;
	@NotNull(message="Address should not be null")
	private Address address;

    
	@NotNull(message="Requested Loan amount should not be null")
    private  Double requestedLoanAmount;
	@NotNull(message="Product Value should not be null")
    private  Double productValue;
	@NotNull(message = "Tenure shouldn't be NULL OR EMPTY")
    private int tenure;
	
	
	
//	private String Address;

}
