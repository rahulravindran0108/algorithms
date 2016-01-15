import java.util.*;

class ParanthesisBalancing {

	static boolean isBalanced(String input) {

		Stack<Character> balanceStack = new Stack<Character>();

		for(int i=0;i<input.length();i++) {
			char currentCharacter = input.charAt(i);
			if(currentCharacter == '(')
				balanceStack.push(currentCharacter);
			else if(currentCharacter == ')' && (char) balanceStack.peek() == '(')
				balanceStack.pop();
			else if(currentCharacter == ')' && (char) balanceStack.peek() != '(')
				return false;
			else
				continue;
		}
		if(balanceStack.size() > 0)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {

		String input = "((())";
		System.out.println(isBalanced(input));
		
	}
}