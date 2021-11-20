package com.capp.exception;

public class BlockedUserException extends Exception{

	public BlockedUserException()
	{
		
	}
	public BlockedUserException(String errordesc)
	{
		super(errordesc);
	}
}
