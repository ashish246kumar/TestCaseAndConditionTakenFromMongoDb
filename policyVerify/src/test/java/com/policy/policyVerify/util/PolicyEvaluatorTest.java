package com.policy.policyVerify.util;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.policy.model.entity.PolicyCondition;
import com.policy.model.entity.PolicyRequest;
import com.policy.model.entity.Rule;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.mockito.junit.jupiter.MockitoExtension;

class PolicyEvaluatorTest {

	private ExpressionParser mockParser;


    private Expression mockExpression;

   
    private PolicyEvaluator policyEvaluator;

    
    

	Rule rule;
	PolicyCondition policyCondition;
	List<PolicyCondition> expectedPolicyConditionList;
	PolicyRequest policyRequest;
	@BeforeEach
	void setUp(){
		
		mockParser=mock(ExpressionParser.class);
		mockExpression=mock(Expression.class);
		policyEvaluator=new PolicyEvaluator(mockParser);
		

		rule = new Rule(
			    "customerNationality",
			    "({'JIOCD', 'JIOML', 'JINML', 'JINCD', 'OGLDP'}.contains(#root['productId'])) and #root['customerNationality'] != 'Indian'",
			    "PA-CF-001",
			    "Nationality is other than Resident Indian"
			);
		policyCondition=new PolicyCondition(
			    "6628eb9d4dcc8b0525be4bae",
			    "JIO",
			    rule
			);
		 expectedPolicyConditionList=List.of(policyCondition);
		 policyRequest=PolicyRequest.builder()
		            .productId("JIOCD")
		            .customerNationality("NIndian")
		            .employmentType("NSalaried")
		            .build();
	
		 
	}

	@Test
	void testEvaluate() {
		 ObjectMapper mapper = new ObjectMapper();
		 Map<String, Object> requestData = mapper.convertValue(policyRequest, Map.class);
		 when(mockParser.parseExpression(anyString()))
			.thenReturn(mockExpression);
		 when(mockExpression.getValue(any(StandardEvaluationContext.class), eq(Boolean.class))).thenReturn(true);
		
		 Map<String, String> result=policyEvaluator.evaluate(requestData, expectedPolicyConditionList);
		 assertEquals(1, result.size());
		 assertTrue(result.containsKey("PA-CF-001"));
		 assertEquals("Nationality is other than Resident Indian", result.get("PA-CF-001"));
	}
	@Test
	void testEvaluateFalseCondition() {
		 ObjectMapper mapper = new ObjectMapper();
		 Map<String, Object> requestData = mapper.convertValue(policyRequest, Map.class);
		 when(mockParser.parseExpression(anyString()))
			.thenReturn(mockExpression);
		 when(mockExpression.getValue(any(StandardEvaluationContext.class), eq(Boolean.class))).thenReturn(false);
		
		 Map<String, String> result=policyEvaluator.evaluate(requestData, expectedPolicyConditionList);
		 assertEquals(0, result.size());
		 
	}

}
