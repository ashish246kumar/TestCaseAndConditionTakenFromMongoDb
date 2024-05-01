package com.policy.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rule {
     
	 private String name;
     private String expression;
	 private String reasonCode;
	 private String message;
}
