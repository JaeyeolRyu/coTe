package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1012 {
	static int N;
	static int M;
	static int K;
	static int[] yy = {-1,0,0,1};
	static int[] xx = {0,-1,1,0};
	static int[][] arr;
	static boolean[][] visit;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		

		int a;
		int b;
		
		for(int i = 0 ; i < T; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[M][N];
			visit = new boolean[M][N];
			
			for(int j = 0 ; j < K ; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
				
			}
			dfs();
			sb.append(count).append('\n');
			count = 0;
		}
		System.out.println(sb);
	}

	
	public static void dfs() {
		
		for(int i = 0 ; i < M; i++) {
			
			for(int j = 0; j < N; j++) {
				
				if(arr[i][j] == 1 && !visit[i][j]) {
					
					visit[i][j] = true;
					count++;
					find(i,j);
					
				}
			}
		}
	}
	
	public static void find(int x, int y) {
		
		for(int i = 0; i < xx.length; i++) {
			
			int a = x + xx[i];
			int b = y + yy[i];
			
			if(a >= 0 && b >= 0 && a < M && b < N) {
				
				if(arr[a][b] == 1 && !visit[a][b]) {
					visit[a][b] = true;
					find(a,b);
				}
			}
		}
	}
}
