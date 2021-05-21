package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1934 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 0;
		int min = 0;
		
		for(int i = 0; i < T ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			

			if(a < b) {
				
				int temp = a;
				a = b;
				b = temp;
				
			}
			
			min = proc(a,b);
			
			sb.append(min*(a/min)*(b/min)).append("\n");
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
