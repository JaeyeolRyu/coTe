package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a < b) {
			
			int temp = a;
			a = b;
			b = temp;
			
		}
		
		int min = proc(a,b);
		
		System.out.println(min);
		System.out.println(min*(a/min)*(b/min));
	}

	public static int proc(int a, int b) {

		
		if(a%b == 0) {

			return b;
			
		}
		
		return proc(b,a%b);
	
	}
	
	
	
}
