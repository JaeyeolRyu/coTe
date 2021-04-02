package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992 {

	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			
			String str = br.readLine();
			String[] s = str.split("");
			for(int j = 0 ; j < N ; j++) {
				
				arr[i][j] = Integer.parseInt(s[j]) ;
	
			}
			
		}
		if(N == 1) {
			sb.append("(");
			sb.append(arr[0][0]);
			sb.append(")");
		} else {
			proc(0,0,N);
		}
		
		
		
		
		System.out.println(sb);
	}

	public static void proc(int x, int y, int num) {
		
		for(int i = x; i < x+num; i++) {
			
			for(int j = y; j < y+num; j++) {
				
				if(arr[x][y]!=arr[i][j]) {
					
					sb.append("(");
					proc(x, y, num/2);
					proc(x, y+num/2, num/2);
					proc(x+num/2, y, num/2);
					proc(x+num/2, y+num/2, num/2);	
					sb.append(")");
					
					return;
				}
	
			}
			
		}
		
		sb.append(arr[x][y]);
		
	}
}
