package com.phillippham.arraystack;

public class EmptyCollectionException extends Exception
{
	public EmptyCollectionException()
	{
		super("Stack is empty.");
	}
	
	public EmptyCollectionException(String message)
	{
		super(message);
	}
}
