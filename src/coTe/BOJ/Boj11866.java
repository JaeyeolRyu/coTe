package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11866 {
	
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		

		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		for(int i = 1; i <= N; i++) {
			
			q.offer(i);
			
		}
		
		proc(N,K);
	}

	public static void proc(int N, int K) {
		sb.append("<");
		while(q.size() != 1) {
			
			for(int i = 1 ; i < K ; i++) {
				
				q.offer(q.poll());
				
			}
			sb.append(q.poll()).append(", ");
			
		}		
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);

	}

	
}
