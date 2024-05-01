package com.policy.policyVerify.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.policy.model.entity.PolicyRequest;
import com.policy.model.entity.PolicyResponse;
import com.policy.policyVerify.handler.PolicyConditionException;
import com.policy.policyVerify.service.impl.PolicyEngineRequestLogService;
import com.policy.policyVerify.service.impl.PolicyRuleVerify;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class PolicyController {


	private final PolicyRuleVerify policyRuleVerify;
	
	  private final PolicyEngineRequestLogService policyEngineRequestLogService;
	public PolicyController(PolicyRuleVerify policyRuleVerify,PolicyEngineRequestLogService policyEngineRequestLogService) {
		this.policyRuleVerify=policyRuleVerify;
		this.policyEngineRequestLogService=policyEngineRequestLogService;
	}
	
	private static final Logger log = LoggerFactory.getLogger(PolicyController.class);
	
	
	
	@PostMapping("/validate")
	public ResponseEntity<PolicyResponse> validateApplicant(@RequestParam String id,@RequestBody @Valid PolicyRequest policyRequest) throws PolicyConditionException{
		log.info("PolicyController::validateApplicant By PrductId {}", policyRequest.getProductId());
		try {
		PolicyResponse policyResponse =policyRuleVerify.validatePolicy(id,policyRequest);
		policyEngineRequestLogService.savePolicyRequestResponse(policyRequest, policyResponse);
		log.info("PolicyController::validateApplicant response {}", policyResponse);
        return new ResponseEntity<>(policyResponse, HttpStatus.OK);
		}
		catch(PolicyConditionException e) {
			throw e;
		}
	}
  

}