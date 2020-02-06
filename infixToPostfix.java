import java.util.*;

public class infixToPostfix {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = "(A+B*C-D)*((E+F)^G)";
		System.out.println(postfix(str));
	}

	public static String postfix(String str) {

		Stack<Character> s = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				sb.append(str.charAt(i));
			} else if (str.charAt(i) == '(') {
				s.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				while (!s.isEmpty() && s.peek() != '(') {
					sb.append(s.pop());
				}
				if (!s.isEmpty() && s.peek() == '(') {
					s.pop();
				}
			} else {
				boolean flag1 = false;
				if (s.isEmpty()) {
					s.push(str.charAt(i));
				} else {
					boolean flag = operatorPrecedence(str.charAt(i), s.peek());
					if (flag) {
						s.push(str.charAt(i));
					} else {
						while (!s.isEmpty() && s.peek() != '(') {
							sb.append(s.pop());
							if (!s.isEmpty() && operatorPrecedence(str.charAt(i), s.peek())) {
								s.push(str.charAt(i));
								flag1 = true;
								break;
							}
						}
						if (!flag1) {
							s.push(str.charAt(i));
						}
					}
				}
			}
		}

		while (!s.isEmpty()) {
			sb.append(s.pop());
		}

		return sb.toString();

	}

	public static boolean operatorPrecedence(char curr, char prev) {
		if (curr == '^') {
			return true;
		} else if ((curr == '/' || curr == '*') && (prev == '+' || prev == '-')) {
			return true;
		} else if (curr == prev) {
			return true;
		} else if (prev == '(') {
			return true;
		} else {
			return false;
		}
	}

}
