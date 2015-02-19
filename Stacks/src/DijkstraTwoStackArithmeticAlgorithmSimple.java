/**
 * @author Warosaurus
 *
 * This is a simple implementation of Dijkstra's Two-Stack Arithmetic Algorithm.
 * (Not covered in the course, created for fun and profit?)
 *
 * Algorithm:
 * - value: push onto value stack.
 * - operator: push onto operator stack.
 * - left parenthesis: ignore.
 * - right parenthsis: pop last two values off values stack, pop operator off of operator stack, apply the operator
 *  to both values, push result onto values stack.
 *
 * How I plan to tackle the implementation:
 * - Take in a String representing an arithmetic expression such as: (3 + (2 * 8) + ( 4 - 2) + 12 ).
 * - Split this string into characters.
 * - Read first character, if character is a number and next character is also a number then group these together.
 *  - If not then, if the next character either whitespace or a left parenthesis then ignore it.
 *  - If the next character is an operator then push the value onto the value stack, then push the operator onto the
 *  operator stack.
 *  - If the next character is a right parenthesis then pop the last two values from the values stack, pop the last
 *  operator from the operator stack.
 *  - perform the operation on the two values, then push the result back onto the value stack.
 * - Repeat until there are no characters left.
 */


// *Needs testing

public class DijkstraTwoStackArithmeticAlgorithmSimple {

	private GenericResizingStackArray<Integer> values;
	private GenericResizingStackArray<Character> operators;
	private char[] c;

	public DijkstraTwoStackArithmeticAlgorithmSimple() {
		values = new GenericResizingStackArray<Integer>();
		operators = new GenericResizingStackArray<Character>();
		// *Need to add validate the string
//		c = sequence.toCharArray();
	}

	public int evaluate(String expression) {
		c = expression.toCharArray();
		int i = 0;
		while(i < c.length) {
			if (c[i] == ')')
				calculate();
			else if ((int) c[i] >= 42 && (int) c[i] <= 45)
				operators.push(c[i]);
			else if (Character.isDigit(c[i])) {
				String x = "" + c[i];
				while(Character.isDigit(c[i+1]))
					x += c[i++];
				values.push(Integer.parseInt(x));
			}
			i++;
		}
		return values.pop();
	}

	private void calculate() {
		int result = 0;
		int var2 = values.pop();
		int var1 = values.pop();
		char op = operators.pop();

		if (op == '+')
			result = var1 + var2;
		else if (op == '-')
			result = var1 - var2;
		else if (op == '*')
			result = var1 * var2;
		else if (op == '/')
			result = var1/var2;
		values.push(result);
	}
}
