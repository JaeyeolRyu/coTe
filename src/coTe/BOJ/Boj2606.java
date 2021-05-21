package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606 {
	
	static int[][] arr;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		int a;
		int b;
		StringTokenizer st;
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(count);
		
	}

	public static void dfs(int num) {
		
		visit[num] = true;
		
		for(int i = 1; i < visit.length; i++) {
			
			if(!visit[i] && arr[num][i] == 1) {
				
				visit[i] = true;
				count++;
				dfs(i);
				
			}
				
		}
		
	}
}
