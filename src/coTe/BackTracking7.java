package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking7 {

	static int[] arr ;
	static int[] calc = new int[4];
	static int N = 0;
	static int max = -1000000000;
	static int min = 1000000000;
	static int temp = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}

		st = new StringTokenizer(br.readLine(), " ");
		
		for(int j = 0; j < 4 ; j++) {
			
			calc[j] = Integer.parseInt(st.nextToken());
		}
		 
		cal(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void cal(int num, int depth) {
		
		if(N == depth) {
			
			if(num > max) {
				max = num;
			}
			
			if(num < min) {
				min = num;
			}
		
			return;
		}
		
		for(int i = 0 ; i < 4; i++) {
			
			if(calc[i] > 0) {
				
				calc[i] --;
				
				if(i == 0) {
					cal(num + arr[depth], depth + 1);
				} else if(i == 1) {
					cal(num - arr[depth], depth + 1);
				} else if(i == 2) {
					cal(num * arr[depth], depth + 1);
				} else if(i == 3) {
					cal(num / arr[depth], depth + 1);
				}
				
				calc[i]++;	
			}
			
		}
		
	}

}
