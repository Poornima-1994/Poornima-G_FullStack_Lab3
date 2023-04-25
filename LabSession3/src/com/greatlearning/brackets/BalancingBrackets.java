package com.greatlearning.brackets;

import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		String bracketExpression = "{[][]()}";
		if(isBracketsBalanced(bracketExpression)) {
			System.out.println("Brackets are balanced");
		}else {
			System.out.println("Brackets are not balanced");
		}

	}
	/*
	 *For Each character in the given expression
	 *If Open Bracket  -- Push it to stack
	 *else if Close Bracket -- pop and then validate it's corresponding open bracket.
	 *return stack.isEmpty()
	 */
	private static boolean isBracketsBalanced(String bracketExpression) {
		Stack<Character> stack =new Stack<>();
		char[] chars = bracketExpression.toCharArray();
			for(char c : chars) {
				if (c == '(' || c == '[' || c == '{') {
					stack.push(c);
			}else if (c == ')'|| c == ']' || c == '}') {
				if (stack.isEmpty()) {		
				 return false;
	  }
				char ch = stack.pop();	
				switch(c)
				{
				case')':
					if (ch !='(') {
						return false;
					}
					break;
				case'}':
					if (ch !='{') {
						return false;
					}
					break;
				case']':
					if (ch !='[') {
						return false;
					}
					break;
				 }
		    }   
		}
		return stack.isEmpty();
	}

}
