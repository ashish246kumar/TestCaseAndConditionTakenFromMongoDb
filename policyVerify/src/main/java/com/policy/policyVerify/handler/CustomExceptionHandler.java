package com.policy.policyVerify.handler;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.policy.model.dto.ErrorDTO;
import com.policy.model.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import java.util.*;

@ControllerAdvice
public class CustomExceptionHandler {


	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleRequestValidationException(MethodArgumentNotValidException ex,HttpServletRequest request) {

		
	        List<ErrorDTO> errors = new ArrayList<>();
	        ex.getBindingResult().getFieldErrors()
	                .forEach(error -> {
	                   errors.add(ErrorDTO.builder().field(error.getField()).errorMessage(error.getDefaultMessage()).build());
	                });
	     
	        return ErrorResponse.builder().status("FAILED").errors(errors).build();
		
		
	
	}
	@ExceptionHandler(PolicyConditionException.class)
	@ResponseBody
	public Map<String,String> handlePolicyConditionException(PolicyConditionException ex){
		Map<String,String> map=new HashMap<>();
		map.put("message",ex.getMessage());
		return map;
	}
}
