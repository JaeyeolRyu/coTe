package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
	
	static int[][][] arr;
	static Queue<Location> q = new LinkedList<Location>();
	static int[] xx = {-1,0,0,1,0,0};
	static int[] yy = {0,-1,1,0,0,0};
	static int[] zz = {0,0,0,0,-1,1};
	static int M;
	static int N;
	static int H;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M][H];
		
		for(int i = 0 ; i < H; i++) {
			
			for(int j = 0 ; j < N; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				for( int k = 0 ; k < M; k++) {
					
					arr[j][k][i] = Integer.parseInt(st.nextToken());
					
					if(arr[j][k][i] == 1) {
						q.offer(new Location(j, k, i));
					}
				}
				
			}
			
		}
	
		bfs();
	
	}

	public static void bfs() {
		
		while(!q.isEmpty()) {
			
			Location lo = q.poll();
			
			for(int i = 0 ; i < xx.length; i++) {
				
				int a = lo.x + xx[i];
				int b = lo.y + yy[i];
				int c = lo.z + zz[i];
				
				if(a >= 0 && b >= 0 && c >= 0 && a < N && b < M && c < H) {
					
					if(arr[a][b][c] == 0) {
						
						arr[a][b][c] = arr[lo.x][lo.y][lo.z] + 1;
						
						q.offer(new Location(a, b, c));
						
					}
					
				}
				
			}
			
		}
		
		int max = 0;
		
		for( int i = 0 ; i < N; i++) {
			
			for( int j = 0 ; j < M ; j++) {
				
				for(int k = 0 ; k < H; k++ ) {
					
					if(arr[i][j][k] == 0 ) {
						
						System.out.println(-1);
						System.exit(0);
						
					} else {
						
						max = Math.max(max, arr[i][j][k]);
						
					}

				}
				
			}

		}
		
		System.out.println(max-1);
	}
	
	
	
}

class Location {
	
	int x;
	int y;
	int z;
	
	Location(int x, int y, int z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	
	
}

