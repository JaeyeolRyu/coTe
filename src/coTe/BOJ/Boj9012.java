package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9012 {

	static char[] stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			int size = 0;
			stack = br.readLine().toCharArray();
			
			for(int j = 0; j < stack.length; j++) {
				
				if(stack[j] == '(') {
					size++;
				} else {
					size--;
				}		
				
				if(size == -1) {
					break;
				}
			}
			
			if(size == 0) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

}
