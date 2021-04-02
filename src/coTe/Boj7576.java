package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
	
	static int[][] arr;
	static int[] xx = {-1,0,0,1};
	static int[] yy = {0,-1,1,0};
	static int N;
	static int M;
	static int count = 0;
	static Queue<Location> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
		
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 0; j < M; j++) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1) {
					q.offer(new Location(i, j));
				}
			
			}

		}
		
		bfs();
		
	}

	public static void bfs() { 
		
		
		
		while(!q.isEmpty()) {
			
			Location lo = q.poll();
			
			for(int i = 0; i < xx.length; i++) {
				
				int a = lo.x + xx[i];
				int b = lo.y + yy[i];
				
				if( a >= 0 && b >= 0 && a < N && b < M ) {
					
					if(arr[a][b] == 0) {
						
						arr[a][b] = arr[lo.x][lo.y] + 1;
						q.offer(new Location(a, b));
					}
					
					
				}
	
			}	
			
		}
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0 ; j < M; j++) {
				
				if(arr[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				} else {
					
					max = Math.max(max, arr[i][j]);
				}
				
			}
			
		}
		
		System.out.println(max-1);
		
	}
	
	static class Location {
		
		int x;
		int y;
		
		Location(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
}
