package coTe.Pro;

import java.util.Stack;

class ProParenthesisRotation {

	public int solution(String s) {
		int answer = 0;

		StringBuilder sb;

		if (s.length() % 2 != 0) {
			return 0;
		}

		for (int i = 0; i < s.length(); i++) {

			sb = new StringBuilder();

			sb.append(s.substring(i));
			sb.append(s.substring(0, i));

			answer += isPossible(sb.toString());
		}
		return answer;
	}

	public int isPossible(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {

				stack.add(str.charAt(i));

			} else {

				if (stack.isEmpty()) {
					return 0;
				} else {

					switch (str.charAt(i)) {
					case ')':

						if (stack.pop() != '(') {
							return 0;
						}

						break;
					case '}':

						if (stack.pop() != '{') {
							return 0;
						}

						break;
					case ']':

						if (stack.pop() != '[') {
							return 0;
						}

						break;
					}

				}

			}
		}

		return 1;
	}

}