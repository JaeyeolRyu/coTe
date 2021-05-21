package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
	
	static int[][] arr;
	static int[][] count;
	static boolean[][] visit;
	static int[] xx = {-1,0,0,1};
	static int[] yy	= {0,-1,1,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		count = new int[N][M];
		String temp;
		String[] str;
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			temp = st.nextToken();
			str = temp.split("");
			
			for(int j = 0; j < M; j++) {
				
				arr[i][j] = Integer.parseInt(str[j]);
				
			}

		}
		
		bfs(N,M);
		System.out.println(count[N-1][M-1]);
	}

	public static void bfs(int N, int M) {
		
		Queue<Location> q = new LinkedList<Location>();
		
		q.offer(new Location(0, 0));
		
		visit[0][0] = true;
		count[0][0] = 1;
		
		while(!q.isEmpty()) {
			
			Location lo = q.poll();
			
			for(int i = 0; i < xx.length; i++) {
				
				int a = lo.x + xx[i];
				int b = lo.y + yy[i];
				
				if(a >= 0 && b >= 0 && a < N && b < M) {
					
					if(arr[a][b] == 1 && !visit[a][b]) {
						
						visit[a][b] = true;
						count[a][b] = count[lo.x][lo.y] + 1;
						q.offer(new Location(a, b));
						
					}
				}
			
			}

		}
		
		
	}
	
	static class Location {
		
		int x;
		int y;
		
		Location(int x, int y) {
		
			this.x = x;
			this.y = y;
		}
		
	}
}
