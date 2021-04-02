package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongjuk7 {

	static int[] arr ;
	static Integer[] sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		sum = new Integer[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			
			arr[i] = Integer.parseInt(br.readLine());
			
		}
	
		
		sum[0] = 0;
		sum[1] = arr[1];
		
		if(N>=2) {
		
			sum[2] = arr[1] + arr[2];
		}
		
		System.out.println(stair(N));
	}
	
	
	
	public static int stair(int num) {
		
		if(sum[num] == null) {
			
			sum[num] = Math.max(stair(num-2), stair(num-3) + arr[num-1]) + arr[num];
			
		}
		return sum[num];
	}
}
