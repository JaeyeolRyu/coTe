package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			if( a == b ) {
				
				if(o1 > o2) {
					return 1;
				} else {
					return -1;
				}
			}
			
			return a - b;
		});
		
		int N = Integer.parseInt(br.readLine());
		int temp ;
		
		for(int i = 0 ; i < N; i++) {
			
			temp = Integer.parseInt(br.readLine());
			
			if(temp == 0) {
				
				if(q.size() == 0) {
					
					sb.append(0).append('\n');
					
				} else {
					
					sb.append(q.poll()).append('\n');
					
				}
				
			}else {
				
				q.offer(temp);
				
			}
	
		}
		
		System.out.println(sb);
		
	}

}
