package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10773 {
	
	static int[] stack;
	static int size = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int temp = 0;
		
		stack = new int[K];
		
		for(int i = 0; i < K; i++) {
			
			temp = Integer.parseInt(br.readLine());
			
			if(temp == 0) {
				
				pop();
				
			} else {
				
				push(temp);
				
			}
			
		}
		
		int sum = 0;
		
		for(int i = 0; i < size; i++) {
			
			sum += stack[i];
			
		}
	
		System.out.println(sum);
	}
	
	public static void push(int num) {	
		stack[size] = num;
		size++;
	}
	
	public static void pop() {
		stack[size-1] = 0;
		size--;
	}
	

}
