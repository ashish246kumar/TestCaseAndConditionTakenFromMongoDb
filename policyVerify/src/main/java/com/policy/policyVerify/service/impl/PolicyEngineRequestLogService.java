package com.policy.policyVerify.service.impl;



import org.springframework.stereotype.Service;

import com.policy.model.entity.PolicyEngineRequestLog;
import com.policy.model.entity.PolicyRequest;
import com.policy.model.entity.PolicyResponse;
import com.policy.policyVerify.repository.PolicyEngineRequestLogRepository;

@Service
public class PolicyEngineRequestLogService {

	
	private final PolicyEngineRequestLogRepository policyEngineRequestLogRepository;
	 public PolicyEngineRequestLogService(PolicyEngineRequestLogRepository policyEngineRequestLogRepository) {
		 this.policyEngineRequestLogRepository=policyEngineRequestLogRepository;
	 }
	 
	public void savePolicyRequestResponse(PolicyRequest policyRequest,PolicyResponse policyresponse){
		 policyEngineRequestLogRepository.save(PolicyEngineRequestLog.builder().requestBody(policyRequest).leadId(policyresponse.getLeadId()).responseBody(policyresponse).build());
		 
	}
}
