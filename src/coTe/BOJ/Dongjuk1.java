package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk1 {
	static int[][] arr = new int[41][2];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		
		for(int i = 0; i < 41; i++) {
			
			arr[i][0] = -1;
			arr[i][1] = -1;
		}
		
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int j = 0 ; j < T; j++) {

			int value = Integer.parseInt(br.readLine());
			if(value >= 2) {
				fibo(value);
			}
			
			sb.append(arr[value][0] + " " + arr[value][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}

	public static int[] fibo(int num) {

		if(arr[num][0] == -1 || arr[num][1] == -1 ) {
			arr[num][0] = fibo(num-1)[0] + fibo(num-2)[0];
			arr[num][1] = fibo(num-1)[1] + fibo(num-2)[1];
		}

		return arr[num];
		
	}
}
