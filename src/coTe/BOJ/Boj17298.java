package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
	
	static Stack<Integer> stack = new Stack<>();
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
	
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		proc(N);
		
		System.out.println(sb);
	}

	public static void proc(int N) {
		
		for(int i = 0; i < N; i++) {
					
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				
				arr[stack.pop()] = arr[i];
				
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			
			arr[stack.pop()] = -1;
			
		}
		
		for(int j = 0; j < N; j++) {
			
			sb.append(arr[j]).append(" ");
			
		}
		
	}
	
}
