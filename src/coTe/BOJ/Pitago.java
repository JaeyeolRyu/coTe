package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pitago {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		while(true) {
			
			StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(tz.nextToken());
			int b = Integer.parseInt(tz.nextToken());
			int c = Integer.parseInt(tz.nextToken());
			
			if(a == 0 && b == 0 && c == 0) {
				break;
			}
			
//			if( c*c == a*a + b*b ) {
//				System.out.println("right");
//			} else {
//				System.out.println("wrong");
//			}
			
			if( a <= b ) {
				
				if ( b < c ) {  // c가 가장클경우
					
					if( c*c == a*a + b*b ) {
						System.out.println("right");
					} else {
						System.out.println("wrong");
					}	
					
				}else { //b가 가장 클 경우
				
					if( b*b == a*a + c*c ) {
						System.out.println("right");
					} else {
						System.out.println("wrong");
					}
					
				}
			} else { // a가 가장 클경우
				
				if( a*a == b*b + c*c ) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}	
				
			}
			
			
			
			
		}
		
		
		
	}

}
