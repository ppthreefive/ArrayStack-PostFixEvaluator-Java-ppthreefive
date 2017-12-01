package com.phillippham.arraystack;

import java.util.StringTokenizer;

public class PostfixEvaluator
{
	// Constant for addition symbol
	private final char ADD = '+';
	
	// Constant for subtraction symbol
	private final char SUBTRACT = '-';
	
	// Constant for multiplication symbol
	private final char MULTIPLY = '*';
	
	// Constant for division symbol
	private final char DIVIDE = '/';
	
	// The stack
	private ArrayStack<Integer> stack;
	
	// Sets up this evaluator by creating a new stack
	public PostfixEvaluator()
	{
		stack = new ArrayStack<Integer>();
	}
	
	/**
	 * Evaluates the specific postfix expression. If an operand is
	 * encountered, it is pushed onto the stack. If an operator is
	 * encountered, two operands are popped, the operation is
	 * evaluated, and the result is pushed onto the stack.
	 * Expression String representation fo a postfix expression
	 * Returns int value of the given expression
	 */
	
	public int evaluate(String expression)
	{
		int op1, op2, result = 0;
		String token;
		StringTokenizer tokenizer = new StringTokenizer(expression);
		
		while(tokenizer.hasMoreTokens())
		{
			token = tokenizer.nextToken();
			
			if(isOperator(token))
			{
				op2 = (stack.pop()).intValue();
				op1 = (stack.pop()).intValue();
				result = evalSingleOp(token.charAt(0), op1, op2);
				stack.push(new Integer(result));
			}
		}
		
		return result;
	}
	
	/** Determines if the specified token is an operator.
	 * token String representing a single token
	 * boolean true if token is operator 
	 */
	private boolean isOperator(String token)
	{
		return ( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") );
	}
	
	/** Performs integer evaluation on a single expression consisting of
	 * the specified operator and operands.
	 * parameter operation operation to be performed
	 * op1 --> the first operand
	 * op2 --> the second operand
	 * returns int value of the expression
	 */
	private int evalSingleOp(char operation, int op1, int op2)
	{
		int result = 0;
		
		switch(operation)
		{
			case ADD:
				result = op1 + op2;
				break;
			case SUBTRACT:
				result = op1 - op2;
			case MULTIPLY:
				result = op1 * op2;
				break;
			case DIVIDE:
				result = op1 / op2;
		}
		return result;
	}
}
