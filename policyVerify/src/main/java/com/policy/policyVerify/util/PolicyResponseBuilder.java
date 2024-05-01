package com.policy.policyVerify.util;

import java.util.Map;

import com.policy.model.entity.PolicyResponse;

public class PolicyResponseBuilder {

	public static PolicyResponse build(String leadId, String productId, Map<String, String> response) {
        return PolicyResponse.builder()
                             .leadId(leadId)
                             .productId(productId)
                             .response(response)
                             .build();
    }
}
