package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sosu2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int First = Integer.parseInt(br.readLine());
		int Last  = Integer.parseInt(br.readLine()); 
		
		System.out.println(cal(First,Last));
		
	}
	
	public static String cal(int a, int b) {

		int count = 0;
		int j = 0;
		int min = 0;
		int sum = 0;
		
		for(int i = a; i < b + 1 ; i++) { 
		
			
			for( j = 2 ; j < i ; j++ ) {
				
				if( i % j == 0 ) {	
					break;
				}

				
			}

			if(i == j) {
				count ++;
				
				if(count == 1 ) {
					min = j;
				}
				
				sum += j;
			
			}
	
		}
	
		if ( count == 0 ) {
			return "-1";
		}
		
		return sum + "\n" + min;
		
	}
	

}
