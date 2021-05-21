package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
		
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
