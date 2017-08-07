package com.java_concepts.custom_exceptions;

public class InvalidProductException extends Exception {
	
	int productId;
	
	public InvalidProductException(){
		super("Invalid Default Parameters");
	}
	
	public InvalidProductException(int productId, String message){
		super(message);
		this.productId = productId;
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
	
	@Override 
	public String getMessage() { 
		return super.getMessage() + " for productId :" + productId; 
	}
}
