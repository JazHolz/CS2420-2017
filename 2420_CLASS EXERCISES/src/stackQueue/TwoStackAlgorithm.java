package stackQueue;

import edu.princeton.cs.algs4.Stack;

/**
 * Implements the 2 stack algorithm form Dijkstra
 * to evaluate expressions.
 * 
 * @author Jazmine Lavasani
 *
 */

public class TwoStackAlgorithm {

	public static void main(String[] args) {
		
		String expression = "(4 + (( 6 / 2 ) * ( 5 - 2)))";
		
		System.out.println(expression + " = "  + evaluateExpression(expression));

		}

	private static int evaluateExpression(String expression) {
		Stack<Integer> values = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(int i = 0; i < expression.length(); i++) {
			
			char c = expression.charAt(i);
			
			if( c == '(' || c == ' ') 
				continue;
			else if ( c == '*' || c == '/' || c == '+' || c == '-')
				operators.push(c);
			else if( Character.isDigit(c))
				values.push(Integer.parseInt("" + c));
			else if (c == ')')
				eval(values,operators.pop());
				
			}
		return values.peek();
	}

	private static void eval(Stack<Integer> values, Character operator) {
		int value1 = values.pop();
		int value2 = values.pop();
		int result = 0;
		char Operator = operator;
		
		switch(Operator) {
		case '*':
			result = value2 * value1;
			break;
		case '/':
			result = value2 / value1;
			break;
		case '+':
			result = value2 + value1;
			break;
		case '-':
			result = value2 - value1;
			break;	
		default:
			System.out.println("Operator value is broken");
		}
	values.push(result);
	}
}
