package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking6 {

	static int[][] arr = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		
		for( int i = 0; i < 9 ; i++ ) {
			
			st = new StringTokenizer(br.readLine());
			 
			for( int j = 0; j < 9 ; j++ ) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		solve(0,0);
		
	}

	public static void solve(int x, int y) {
		
		if(y == 9) {
			solve(x+1, 0);
			return;
		}
		
		if(x == 9) {
			
			for( int k = 0; k < 9 ; k++ ) {
				
				for( int l = 0; l < 9 ; l++ ) {
					
					sb.append(arr[k][l]).append(' '); 
					
				}
				
				
				sb.append('\n');
				
			}
			
			System.out.println(sb);
			System.exit(0);
		}
		
		if(arr[x][y] == 0) {
			
			for(int i = 1; i <= 9 ; i++) {
				
				if(possible(x,y,i)) {
					arr[x][y] = i;
					solve(x,y+1);
				}
				
			}
			arr[x][y] = 0;
			return;
		}
	
		solve(x,y+1);

	}
	
	public static boolean possible (int x, int y, int value) {
		
		for(int i = 0 ; i < 9; i++) {
			
			if(arr[x][i] == value || arr[i][y] == value) {
				 return false;
			}
				
		}
			
		for(int j = (x/3)*3 ; j < (x/3)*3 +3; j++) {
			
			for(int k = (y/3)*3 ; k < (y/3)*3 +3 ; k++) {
				
				if(arr[j][k] == value) {
					return false;
				}
				
				
			}
			
			
		}
			
		return true;
	}
	
}
