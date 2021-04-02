package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apart {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for ( int i = 0 ;  i < T; i++ ) {
		
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(cal(k, n));
			
		}

	}
	
	public static int cal(int k, int n) {
		
		int res = 0;
		int [][] arr = new int [k+1][n+1]; 
		
		for ( int i = 1 ; i < n + 1 ; i ++ ) { // 얘가 0층에 사람넣기
			
			arr[0][i] = i ;
			
		}
		
		for ( int j = 1 ; j < k + 1 ; j++ ) { // 층을 다룬다.
			
			for ( int m = 1; m < n + 1 ; m++ ) { // 호수를 다룬다.
				
				arr[j][m] = arr[j-1][m] + arr[j][m-1];
				
			}

		}
		
		res = arr[k][n];
		
		return res;
	}
	

}
