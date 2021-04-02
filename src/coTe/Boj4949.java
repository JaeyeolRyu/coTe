package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

		while(true) {
			
			String str = br.readLine();
			
			if(str.charAt(0) == '.') {
				break;
			}
			sb.append(proc(str)).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	public static String proc(String str) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if(c == '.') {
				
				if(stack.empty()) {
					
					return "yes";
				} else {
					
					return "no";
				}
				
			} else if(c == '[') {
				
				stack.push('[');
				
			} else if(c == ']') {
				
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}else {
					stack.pop();
				}
				
			} else if(c == '(') {
				
				stack.push('(');
				
			} else if(c == ')') {
				
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop();
				}
			}	
			
		}

		return null;
		
	}
	
}
