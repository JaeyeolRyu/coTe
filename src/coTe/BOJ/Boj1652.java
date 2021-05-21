package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1652 {

	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int i = 0; i < N ; i++) {
			
			arr[i] = br.readLine().toCharArray();
		
		}

		proc(N);
	}

	public static void proc(int N) { 
		
		int garo = 0;
		int sero = 0;
		
		for(int i = 0; i < N ; i++) {
			
			for(int j = 0; j < N-1 ; j++) {
				
				if(j == 0) {
					
					if(arr[i][j] == '.' && arr[i][j+1] == '.') {
						
						garo++;
						
						continue;
					}
					
				} else if( arr[i][j-1] == 'X') {
					
					if(j+1 < N) {
						
						if(arr[i][j] == '.' && arr[i][j+1] == '.') {
							
							garo++;
							
							continue;
						}
	
					}
	
				}
	
			}
				
		}
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N-1 ; j++) {
				
				if(j == 0) {
					
					if(arr[j][i] == '.' && arr[j+1][i] == '.') {
						
						sero++;
						
						continue;
					}
					
				} else if( arr[j-1][i] == 'X') {
					
					if(j+1 < N) {
						
						if(arr[j][i] == '.' && arr[j+1][i] == '.') {
							
							sero++;
							
							continue;
						}
	
					}
	
				}
	
			}
				
		}
		
		System.out.println(garo + " " + sero);
		
	}
}
