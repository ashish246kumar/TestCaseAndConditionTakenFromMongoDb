package com.policy.policyVerify.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.policy.model.entity.AdditionalAddress;
import com.policy.model.entity.Address;
import com.policy.model.entity.CurrentAddress;
import com.policy.model.entity.PolicyRequest;

class MapperTest {

	PolicyRequest policyRequest;
	
	@BeforeEach
	void setUp() {
		Address address=new Address();
		CurrentAddress currentAddress=new CurrentAddress("Delhi","546789");
		AdditionalAddress addtionalAddress=new AdditionalAddress("Banglore","90001");
		address.setCurrentAddress(currentAddress);
		address.setAdditionalAddress(addtionalAddress);
		policyRequest=PolicyRequest.builder()
				.productId("JIOCD")
				.customerNationality("NIndian")
				.employmentType("NSalaried")
				.address(address)
				.requestedLoanAmount((double)4000)
				.productValue((double)11000)
				.tenure(27)
				.build();
		
		
	}

	@Test
	void postiveTestConvertToMap() {
		
		Map<String,Object> requestData=Mapper.convertToMap(policyRequest);
		assertNotNull(requestData);
		assertEquals(requestData.get("productId"),policyRequest.getProductId());
	}
	@Test
	void NegativeTestConvertToMap() {
		policyRequest=PolicyRequest.builder().build();
		Map<String,Object> requestData=Mapper.convertToMap(policyRequest);
		assertEquals(null, requestData.get("productId"));

	}

}
