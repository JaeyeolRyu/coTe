package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sosu1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
		
		for ( int i = 0 ; i < N ; i++ ) {
			
			int num = Integer.parseInt(tz.nextToken());
			int j = 0;
			
			
			if( num == 1 ) { 
				continue;
			}
			
			for( j = 2; j < num ; j++) {
				 	
				 if( num%j == 0) {
					 break;
				 }
				 			 
			 }
			
			if( num == j ) {
				count++;
			 }
			
		}
		
		System.out.println(count);
		
	}

}
