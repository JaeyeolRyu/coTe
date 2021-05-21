package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {
	
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 0 ; j < N ; j++) {
			
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
	
		}
		
		proc(0,0,N);
		System.out.println(white);
		System.out.print(blue);
	}

	public static void proc(int x, int y, int num) {
			
		if(num == 1) {
			
			if(arr[x][y] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}

		
		for(int i = x; i < x+num; i++) {
			
			for(int j = y; j < y+num; j++) {
				
				if(arr[x][y] != arr[i][j]) {
					
					proc(x, y, num/2);
					proc(x, y+num/2, num/2);
					proc(x+num/2, y, num/2);
					proc(x+num/2, y+num/2, num/2);	
					
					return;
				}
				
			}

		}
		
		if(arr[x][y] == 0) {
			white++;
		}else {
			blue++;
		}
	
	}
	
}
