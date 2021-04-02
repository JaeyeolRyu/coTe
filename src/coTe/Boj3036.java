package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3036 {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int temp;
		for(int j = 1; j < N ; j++) {
			temp = 0;
			if(arr[0] < arr[j]) {
				temp = proc(arr[j],arr[0]);
			} else {
				temp = proc(arr[0],arr[j]);
			}
			
			sb.append(arr[0]/temp + "/" + arr[j]/temp).append("\n");
		}
		
		System.out.println(sb);
	}

	public static int proc(int a, int b) {
		
		if(a%b == 0) {
			
			return b;
		} 
		
		return proc(b,a%b);
	}
	
	
}
