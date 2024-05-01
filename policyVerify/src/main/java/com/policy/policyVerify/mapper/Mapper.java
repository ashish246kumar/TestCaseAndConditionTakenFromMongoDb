package com.policy.policyVerify.mapper;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.policy.model.entity.PolicyRequest;

public class Mapper {

	public static Map<String,Object> convertToMap(PolicyRequest policyRequest) {
		 ObjectMapper mapper = new ObjectMapper();
		 Map<String,Object> requestData = mapper.convertValue(policyRequest, Map.class);
		 return requestData;
	}
}
