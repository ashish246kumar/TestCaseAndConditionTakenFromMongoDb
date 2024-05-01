package com.policy.policyVerify.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.policy.model.entity.PolicyEngineRequestLog;
public interface PolicyEngineRequestLogRepository extends MongoRepository<PolicyEngineRequestLog,String> {

}
