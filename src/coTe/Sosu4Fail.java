package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sosu4Fail {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			if( n == 0 ) {
				break;
			}
			if (n%2 == 1) {
				n += 1;
			} 
			
			for(int i = n + 1 ; i < 2*n+1 ; i+=2) {
				
				for (int j = 3; j <= i ; j+=2) {
					
					if( i <= j ) {
						count++;
						break;
					}
					
					if( i%j == 0 ) {
						break;
					}
					
				}
	
			}
			
			System.out.println(count);
			
		}
		
	}

}
