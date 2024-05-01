package com.policy.policyVerify.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.policy.model.entity.PolicyCondition;



public interface PolicyConditionRepository extends MongoRepository<PolicyCondition,String>{

	List<PolicyCondition> findByProductId(String productId);
}
