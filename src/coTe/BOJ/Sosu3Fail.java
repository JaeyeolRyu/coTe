package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sosu3Fail {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
		
		int first = Integer.parseInt(tz.nextToken());
		int last  = Integer.parseInt(tz.nextToken());

		if(first % 2 == 0 ) {
			first += 1;
		}
		if(last % 2 ==  0 ) {
			last -= 1;
		}
		cal(first, last);
	}

	public static void cal(int a, int b) {
		// 소수는 2단위가없는듯?
		
		int j = 0;
		
		for(int i = a; i < b + 1 ; i+=2) { 
			
			for( j = 3 ; j < i ; j += 2) {
				
				if( i % j == 0 ) {	
					break;
				}

			}

			if(i == j) {
				
				System.out.println(j);
			}
	
		}
			
	}
	
}
