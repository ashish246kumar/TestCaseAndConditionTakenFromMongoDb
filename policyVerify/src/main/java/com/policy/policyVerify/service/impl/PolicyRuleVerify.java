package com.policy.policyVerify.service.impl;


import java.util.List;
import java.util.Map;




import org.springframework.stereotype.Service;


import com.policy.model.entity.PolicyCondition;

import com.policy.model.entity.PolicyRequest;
import com.policy.model.entity.PolicyResponse;
import com.policy.policyVerify.handler.PolicyConditionException;
import com.policy.policyVerify.helper.LeadIdGenerator;
import com.policy.policyVerify.mapper.Mapper;

import com.policy.policyVerify.repository.PolicyEngineRequestLogRepository;
import com.policy.policyVerify.util.PolicyEvaluator;
import com.policy.policyVerify.util.PolicyResponseBuilder;

@Service
public class PolicyRuleVerify {

	
    
   
   private final PolicyEngineRequestLogRepository policyEngineRequestLogRepository;
   private final PolicyConditionService policyConditionService;
    private final PolicyEvaluator policyEvaluator;
     public PolicyRuleVerify(
    		 PolicyEngineRequestLogRepository policyEngineRequestLogRepository,
    		 PolicyConditionService policyConditionService,
    		 PolicyEvaluator policyEvaluator
    		 ) 
     {
    	this.policyEngineRequestLogRepository=policyEngineRequestLogRepository;
    	this.policyConditionService= policyConditionService;
    	this.policyEvaluator=policyEvaluator;
    	 
     }
    
	public PolicyResponse validatePolicy(String id, PolicyRequest policyRequest) throws PolicyConditionException {
		 
		  
	       Map<String,Object> requestData = Mapper.convertToMap(policyRequest);
	       String leadId=LeadIdGenerator.generateID();
	       List<PolicyCondition> policyConditionList=policyConditionService.findPolicyConditionById(id);
	       if(policyConditionList.isEmpty()) {
	    	   throw new PolicyConditionException("For this id:"+id+"PolicyConditionList not found");
	       }
	       Map<String, String> evaluationResults = policyEvaluator.evaluate(requestData, policyConditionList);
	       if(evaluationResults.isEmpty()) {
	    	   return PolicyResponse.builder().message("All the Condition Satisfied Customer is Eligible to take loan").build();
	       }
          return PolicyResponseBuilder.build(leadId, policyRequest.getProductId(), evaluationResults);
	}
	
	
	
	
	
}
