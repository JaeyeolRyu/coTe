package coTe;

import java.util.Stack;

class ProPairErase {
	
	public static void main(String[] args) {
		
		String s = "baabaa";
		int ans = solution(s);
		System.out.println(ans);
				
	}
	
	public static int solution(String s) {
		
		int answer = 0;
		char c = ' ';
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < s.length(); i++) {
			
			if(stack.isEmpty()) {
				stack.add(s.charAt(i));
				c = s.charAt(i);
				continue;
			}
			
			if(c == s.charAt(i)) {
				stack.pop();
				if(stack.isEmpty()) {
					continue;
				}
				c = stack.peek();
			} else {
				stack.add(s.charAt(i));
				c = s.charAt(i);
			}
	
		}
		
		if(stack.isEmpty()) {
			return 1;
		}
		
		
		return 0;
	}

}