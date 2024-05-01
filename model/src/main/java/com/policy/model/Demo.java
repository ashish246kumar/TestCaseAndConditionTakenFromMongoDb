package com.policy.model;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.policy.model.entity.CurrentAddress;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
public class Demo {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser(); 
		
		CurrentAddress currentAddress=new CurrentAddress("de","21");
		StandardEvaluationContext context = new StandardEvaluationContext(currentAddress);
		String expression = "#root.city == 'de'";
		Boolean result = parser.parseExpression(expression).getValue(context, Boolean.class);
		System.out.println(result);
//		System.out.println(parser.parseExpression("'Welcome SPEL'+'!'").getValue());
//		int a=(int)parser.parseExpression("10 * 10/2").getValue();
//		System.out.println(a); 
//		System.out.println(parser.parseExpression("'Today is: '+ new java.util.Date()").getValue()); 
//		String str="hello";
//		String str1="he";
//		
//		String expression="#this.length()==5";
//		boolean result = parser.parseExpression(expression).getValue(str, Boolean.class);
//		context.setVariable("st", str1);
//		context.setVariable("nationality","other");
//		context.setVariable("productValue",11000);
//		context.setVariable("requestedLoanAmount",5000);
//		context.setVariable("tenor",5);
//				
//		int b = (int)parser.parseExpression("#st.length()").getValue(context);
//		String spelExpression = "#tenor<3 Months";
//		context.setVariable("employment","NSalaried");
//		boolean b1= parser.parseExpression("!(#nationality.equalsIgnoreCase('Indian'))").getValue(context,Boolean.class);
//		System.out.println("........"+b1); 
//		boolean b2=parser.parseExpression(spelExpression.replace(" Months", "")).getValue(context,Boolean.class);
//		
		
//		System.out.println("........"+b2); 
		
		
//		**************************************************************
		
	}

}
