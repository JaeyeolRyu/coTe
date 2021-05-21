package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {

	static int high = 0;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			proc(Integer.parseInt(br.readLine()));
			
			
		}
		
		System.out.println(sb);
	}

	public static void proc(int N) {

		if(N > high) {
				
			for(int i = high+1 ; i <= N; i++ ) {
				
				stack.push(i);
				
				sb.append('+').append('\n');
			}
			
			high = N;
			
		} else if(stack.peek() != N) {
		
			System.out.println("NO");
			System.exit(0);
		}

		stack.pop();
		sb.append('-').append('\n');
		
		
	}
	
	
	
}
