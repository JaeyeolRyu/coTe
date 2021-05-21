package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1966 {
	
	static LinkedList<int[]> q ;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int M = 0;
		
		for(int i = 0; i < T ; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 0; j < N; j++ ) {
	
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
				
			}
			
			proc(N,M);
			
		}
		
		System.out.println(sb);
	}

	public static void proc(int N, int M) {
		
		int count = 0;
		
		while(!q.isEmpty()) {		

			int[] front = q.poll();
			
			boolean max = true;
			for(int j = 0 ; j < q.size(); j++) {
				
				if(front[1] < q.get(j)[1]) {
					
					q.offer(front);
					
					for(int k = 0 ; k < j; k++) {
						
						q.offer(q.poll());
						
					}
				
					max = false;
					break;
					
				}
				
			}
	
			if(!max) {
				continue;
			}
			
			count++;
			
			if(front[0] == M) {
				
				break;
			}
		
			
		}
		
		sb.append(count).append('\n');
	}
}
