package com.policy.policyVerify.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.policy.model.entity.PolicyResponse;

class PolicyResponseBuilderTest {
	
   private Map<String,String> response;
	@BeforeEach
	void setUp()  {
		response=new HashMap<>();
		response.put("PA-CF-007","Max Tenor Norm not met");
	}

	@Test
	void test() {
		String leadId="JIO234";
		String productId="JIOCD";
		PolicyResponse policyResponse=PolicyResponseBuilder.build(leadId,productId, response);
		assertEquals(leadId,policyResponse.getLeadId());
		assertEquals(response,policyResponse.getResponse());
	}
	@Test
	void negativetest() {
      response=new HashMap<>();
		PolicyResponse policyResponse=PolicyResponseBuilder.build(null,null, response);
		assertEquals(null,policyResponse.getLeadId());
		assertEquals(response,policyResponse.getResponse());
		assertNull(policyResponse.getLeadId());
	}

}
