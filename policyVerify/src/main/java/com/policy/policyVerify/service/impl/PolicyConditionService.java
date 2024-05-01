package com.policy.policyVerify.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.policy.model.entity.PolicyCondition;
import com.policy.policyVerify.repository.PolicyConditionRepository;

@Service
public class PolicyConditionService {

	 
	    private final PolicyConditionRepository policyCondtionRepository;
	   public PolicyConditionService(PolicyConditionRepository policyCondtionRepository) {
		   this.policyCondtionRepository= policyCondtionRepository;
	   }
	  
	  
	  public  List<PolicyCondition> findPolicyConditionById(String productId) {
		
		  return policyCondtionRepository.findByProductId(productId);
	  }
}
