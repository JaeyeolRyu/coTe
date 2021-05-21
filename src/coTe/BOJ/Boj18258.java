package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18258 {

	static int end = 0 ;
	static int first = 0;
	static int[] queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		for(int i = 0 ; i < N ; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			
			 switch (st.nextToken()) {
			case "push" :  
				
				push(Integer.parseInt(st.nextToken()));
				
				break;
			case "pop" :  
				
				sb.append(pop()).append('\n');
				
				break;
			case "size" :  
				
				sb.append(size()).append('\n');
				
				break;
			case "empty" :  
				
				sb.append(empty()).append('\n');
				
				break;
			case "front" :  
				
				sb.append(front()).append('\n');
				break;
				
			case "back" :  
				
				sb.append(back()).append('\n');
				break;

			}
			
			
		}
		
		System.out.println(sb);
	}

	
	public static void push(int num) {
		
		queue[end] = num;
		end++;
	}
	
	public static int pop() {
		
		if(first == end) {
			return -1;
		} else {

			int num = queue[first];
			first++;
			return num;
			
		}
	}
	public static int size() {
		
		int num = end-first;
		return num;
		
	}
	public static int empty() {
		
		if(end-first == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	public static int front() {
		
		if(end-first == 0) {
			return -1;
		} else {
			return queue[first];
		}
		
	}
	public static int back() {
		
		if(end-first == 0) {
			return -1;
		} else {
			return queue[end-1];
		}
	}
}
