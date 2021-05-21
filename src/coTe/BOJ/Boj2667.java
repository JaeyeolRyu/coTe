package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2667 {
	static int count = 0;
	static int[][] arr;
	static boolean[][] visit;
	static int[] yy = {-1,0,0,1};
	static int[] xx = {0,-1,1,0};
	static ArrayList<Integer> apart = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int [N][N];
		visit = new boolean[N][N];
		StringTokenizer st;
		String temp;
		String[] str = new String[N];
		
		for(int i = 0 ; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			temp = st.nextToken();
			
			str = temp.split("");
			
			for(int j = 0; j < N; j++) {
				
				arr[i][j] = Integer.parseInt(str[j]);

			}

		}
		
		dfs(0,0);
	
		Collections.sort(apart);
		
		sb.append(apart.size()).append('\n');
		
		for(int i = 0; i < apart.size(); i++) {
			
			sb.append(apart.get(i)).append('\n');
		}
		
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		
		for(int i = 0; i < arr.length; i++) {
			
			for( int j = 0; j < arr.length; j++	) {
				
				if(arr[i][j] == 1 && !visit[i][j]) {
					
					visit[i][j] = true;
					count++;
					find(i,j);
					apart.add(count);
					count = 0;
				}
				
			}
		
		}
			
	}
	
	public static void find(int x, int y) {
		
		for(int i = 0; i < xx.length; i++) {
			
			int a = x + xx[i];
			int b = y + yy[i];
			
			if(a >= 0 && b >= 0 && a < arr.length && b < arr.length) {
				
				if(arr[a][b] == 1 && !visit[a][b]) {
					
					visit[a][b] = true;
					count++;
					find(a,b);
					
				}
				
			}
		}
		
		
		
	}
}
