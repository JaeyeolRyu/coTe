package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1021 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> dq = new LinkedList<Integer>();
		
		int[] arr = new int[M];
		
		for(int i = 1; i < N+1; i++) {
			dq.offerLast(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int j = 0; j < M; j++) {
			
			arr[j] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		for(int k = 0; k < M; k++){
			
			int idx = dq.indexOf(arr[k]);
			
			while(true) {
					
				int temp = dq.peekFirst();
				
				if(temp == arr[k]) {
					dq.pollFirst();
					break;
				}
				
				if(idx >= dq.size()/2.0) {
	
						count++;
						dq.offerFirst(dq.pollLast());
	
					
				} else { 

						count++;
						dq.offerLast(dq.pollFirst());
				}
					
			}

		}
		
		System.out.println(count);
	}

}
