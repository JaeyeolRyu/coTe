package coTe.SW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw11315 {

	static String[][] arr; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T + 1; i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			arr = new String[N][N];
			
			for(int j = 0 ; j < N; j++) {
			
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				
				for(int k = 0; k < N; k++) {
					
					arr[j][k] = String.valueOf(temp.charAt(k));
		
				}
				
			}
			
			sb.append("#" + i + " " + cal(N)).append("\n");
		}
		
		System.out.println(sb);
	}

	public static String cal(int N) {
		
		for(int i = 0 ; i < N ; i++) {
			
			for(int j = 0; j < N ; j++) {
				
				if("o".equals(arr[i][j])) {
					
					String ans = proc(i,j,N);
					
					if("YES".equals(ans)) {
						return ans;
					}
				
				}
				
			}
			
		}
		
		
		return "NO";
		
	}
	
	public static String proc(int x, int y, int N) {
		int garo = 1;
		int sero = 1;
		int daegak1 = 1;
		int daegak2 = 1;
		
		if(y + 5 <= N) {
		
			for(int i = 1; i < 5 ; i++) { //가로
				
				if("o".equals(arr[x][y+i])) {
					
					garo ++;
					
					if(garo == 5) {
						return "YES";
					}
					
				}
	
			}
		}
		
		if( x + 5 <= N ) {  //세로
			
			for(int i=1 ; i<5 ; i++) {
				
				if("o".equals(arr[x+i][y])) {
					
					sero ++;

					if(sero == 5) {
						return "YES";
					}

				} 
				
			}
			
		}
		
		
		if(x + 5 <= N) { // 대각 증가
			
			if( y + 5 <= N ) {
				
				for(int i=1 ; i<5 ; i++) {
					
					if("o".equals(arr[x+i][y+i])) {
						daegak1 ++;
						
						if(daegak1 == 5) {
							return "YES";
						}

					}
					

				}
				
			}
			
		}
		
		if(y - 4 >= 0) { //대각 감소
			
			if( x + 5 <= N ) {
							
				for(int i=1 ; i<5 ; i++) {
					
					if("o".equals(arr[x+i][y-i])) {
						daegak2 ++;
						
						if(daegak2 == 5) {
							return "YES";
						}
						
					} 
					
				}			
							
			}
			
		}
		
		return "NO";
		
	}
}
