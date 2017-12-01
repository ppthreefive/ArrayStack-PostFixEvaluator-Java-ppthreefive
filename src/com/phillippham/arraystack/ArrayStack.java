package com.phillippham.arraystack;

import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T>
{
	private final int DEFAULT_CAPACITY = 100;
	
	private int top;
	
	private T[] stack;
	
	public ArrayStack()
	{
		top = 0;
		stack = (T[])(new Object[DEFAULT_CAPACITY]);
	}
	
	public ArrayStack(int initialCapacity)
	{
		top = 0;
		stack = (T[])(new Object[initialCapacity]);
	}
	
	public void push(T element)
	{
		if(size() == stack.length)
		{
			expandCapacity();
		}
		
		stack[top] = element;
		top++;
	}

	private void expandCapacity()
	{
		T[] larger = (T[])(new Object[stack.length*2]);
		
		for (int i = 0; i < stack.length; i++)
		{
			larger[i] = stack[i];
		}
		
		stack = larger;
	}

	public T pop()
	{
		if(isEmpty())
		{
			try
			{
				throw new EmptyCollectionException();
			} 
			catch (EmptyCollectionException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		top--;
		T result = stack[top];
		stack[top] = null;
		
		return result;
	}

	public T peek()
	{
		if(isEmpty())
		{
			try
			{
				throw new EmptyCollectionException();
			}
			catch (EmptyCollectionException e)
			{
				e.printStackTrace();
			}
		}
		
		return stack[top - 1];
	}

	public boolean isEmpty()
	{
		if(stack.length > 0)
		{
			return false;
		}
		
		return true;
	}

	public int size()
	{
		int size = 0;
		
		for (int i = 0; i < stack.length; ++i)
		{
			size++;
		}
		
		return size;
	}

	public String toString()
	{
		return "ArrayStack [Capacity: " + DEFAULT_CAPACITY + ", Top: " + top + ", Stack: " + Arrays.toString(stack)
				+ ", Type: " + getClass() + "]";
	}
}