package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bunsu {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int count = 1;

		int End = 0;
		while(true) {
			

			End += count;
			
			if(End >= X) {
				break;
			}
			
			count++;
			
		}

		if( count % 2 == 0 ) {
			
			System.out.println((count - (End - X)) + "/" + (End - X + 1) );
			
			
		} else {
			
			System.out.println((End - X + 1 ) + "/" + (count - (End - X)));
			
		}

		
	}

}
