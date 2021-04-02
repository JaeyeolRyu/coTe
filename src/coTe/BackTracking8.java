package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking8 {
	
	static int[][] arr ;
	static boolean[] team;
	static int N = 0;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		team = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 0; j < N; j++) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}	
			
		}
		
		dfs(0,0);
		
		System.out.println(MIN);
	}

	
	public static void dfs(int idx ,int count) {
		
		if( N/2 == count) {
			
			cal();
		}
		
		for(int i = idx; i < N; i++) {
			
			if(!team[i]) {
				
				team[i] = true;
				dfs(i+1,count+1);
				team[i] = false;
				
			}
			
		}
		
		
	}
	
	public static void cal() {
		
		int start = 0;
		int link  = 0;
		
		for(int i = 0; i< N - 1; i++) {

			for( int j = i + 1; j < N; j++) {
				
				if(team[i] && team[j]) {
					start = start + arr[i][j] + arr[j][i];
				} else if(!team[i] && !team[j]) {
					link = link + arr[i][j] + arr[j][i];
				}
				
			}
			
		}
		
		int min = Math.abs(start-link);
		
		if(min == 0 ) {
			System.out.println(min);
			System.exit(0);
			
		}
		
		MIN = Math.min(MIN, min);
		
	}
	
	
}
