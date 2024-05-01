package com.policy.policyVerify.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.policy.model.entity.PolicyCondition;

@Component
public class PolicyEvaluator {

	private ExpressionParser parser;
	public PolicyEvaluator(ExpressionParser parser) {
		this.parser=parser;
	}
	
    public Map<String, String> evaluate(Map<String, Object> requestData, List<PolicyCondition> conditions) {
        Map<String, String> response = new HashMap<>();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(requestData);
      
        for (PolicyCondition policyCondition : conditions) {
        	
            boolean result = parser.parseExpression(policyCondition.getRule().getExpression().toString()).getValue(context, Boolean.class);
            if (result) {
                response.put(policyCondition.getRule().getReasonCode(), policyCondition.getRule().getMessage());
            }
       

        }
        return response;
    }
	
}
