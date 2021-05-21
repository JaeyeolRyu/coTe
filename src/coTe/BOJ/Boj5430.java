package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		LinkedList<Integer> dq ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		char[] arr;
		
		for(int l = 0 ; l < T; l++) {
			boolean isError = false;
			
			dq = new LinkedList<>();
			
			arr = br.readLine().toCharArray();	
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			
			for(int i = 0 ; i < N ; i++ ) {
			
				dq.offer(Integer.parseInt(st.nextToken()));
				
			}
			
			boolean isR = true;
			
			for( int i = 0; i < arr.length; i++) {
	

				if(arr[i] == 'R') {
					
					isR = !isR;
					
				} else {
					
					if(isR) {
						
						if(dq.pollFirst() == null) {
							
							sb.append("error\n");
							isError = true;
							break;
						}
						
					} else {
						
						if(dq.pollLast() == null) {
							
							sb.append("error\n");
							isError = true;
							break;
						}
						
						
					}
						
				}
				
			}
		
			if(!isError) {
				
				int temp = dq.size();
				
				sb.append("[");
				
				if(temp > 0) {
					
					if(isR) {

						sb.append(dq.pollFirst());
						
						for(int k = 0; k < temp-1; k++) {
							
							sb.append(",").append(dq.pollFirst());
						}
						
					} else {
	
							sb.append(dq.pollLast());
							
						for(int k = 0; k < temp-1; k++) {
							
							sb.append(",").append(dq.pollLast());
						}
						

					}
				
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}

}
