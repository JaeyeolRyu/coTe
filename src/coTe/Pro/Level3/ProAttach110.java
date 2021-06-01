package coTe.Pro.Level3;

import java.util.Arrays;
import java.util.Stack;

class ProAttach110 {

	public static void main(String[] args) {

		String[] s = { "1110","100111100","0111111010" };

		String[] ans = solution(s);

		System.out.println(Arrays.toString(ans));

	}

	public static String[] solution(String[] s) {

		String[] answer = new String[s.length];
		Stack<Character> stack;
		StringBuilder sb;
		
		int cnt;
		int ansIdx = 0;
		for (String str : s) {
			
			cnt = 0;
			stack = new Stack<>();
			
			for(int i = 0 ; i < str.length(); i++ ) {
				
				char c3 = str.charAt(i);
				
				if(stack.size() >= 2) {
					
					char c2 = stack.pop();
					char c1 = stack.pop();
					
					if(c1 == '1' && c2 == '1' && c3 == '0') {
						cnt++;
					} else {
						
						stack.push(c1);
						stack.push(c2);
						stack.push(c3);
						
					}
				
				} else {
					stack.push(c3);
				}

			}
			
			sb = new StringBuilder();
			
			while(!stack.isEmpty()) {
				
				sb.insert(0, stack.pop());
				
			}
			
			if(cnt>0) {
				
				int idx = 0;
				if(sb.toString().contains("111")) {
					
					idx = sb.toString().indexOf("111");
					
					while(cnt!=0) {
					
						sb.insert(idx, "110");
						cnt--;
					}
					
				} else {
					
					idx = sb.toString().lastIndexOf('0');
					
					if(idx == -1) {
						
						while(cnt!=0) {
							
							sb.insert(0, "110");
							cnt--;
						}
						
					} else {
						
						while(cnt!=0) {
							
							sb.insert(idx+1, "110");
							cnt--;
						}
						
						
						
					}
					
				}
				
			}
			
			answer[ansIdx] = sb.toString();
			ansIdx++;
			
		}

		return answer;
	}
}