package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk3 {

	static int[] arr = new int [1000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 1000001 ; i ++) {
			arr[i] = -1;
		}
		arr[1] = 1;
		arr[2] = 2;
		System.out.println(dfs(N));


	}

	public static int dfs(int N) {
		
//		if( depth == N ) {
//			count++;
//			if( count >= 15746) {
//				count = count - 15746;
//			}
//			
//			return;
//		}
//		if(N - depth >= 2 ) {
//			
//			dfs(N,depth + 2); // 00넣을떄
//
//		}
//		
//		dfs(N, depth + 1);
		

			if( arr[N] == -1 ) {
				
				arr[N] = dfs(N-1) + dfs(N-2);
				
				if(arr[N] >= 15746) {
					arr[N] = arr[N] % 15746;
				}
			
			}

		
		return arr[N];
		
	}
	
	
	
	
}
