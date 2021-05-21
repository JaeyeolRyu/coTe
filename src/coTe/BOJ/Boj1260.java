package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260 {
	
	static int[][] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		int a;
		int b;
		for(int i = 0 ; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
			
		}
		
		dfs(V);
		sb.append('\n');
		visit = new boolean[N+1];
		
		bfs(V);
		
		System.out.println(sb);
	}

	public static void dfs(int num) {
		
		visit[num] = true;
		sb.append(num).append(" ");
		for(int i = 1; i < visit.length; i++) {
			
			if(!visit[i] && arr[num][i] == 1) {
				
				visit[i] = true;
				dfs(i);
//				visit[i] = false;
			}
			
		}
		
	}
	
	public static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(num);
		sb.append(num).append(" ");
		
		visit[num] = true;
		
		while(!q.isEmpty()) {
			
			int temp = q.poll();
			
			for(int i = 1; i < visit.length; i++) {
				
				if(!visit[i] &&arr[temp][i] == 1) {
					
					q.offer(i);
					visit[i] = true;

					sb.append(i).append(" ");
					
				}
			}
			
		}
		
		
	}
}
