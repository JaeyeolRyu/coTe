package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HotelRoom {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int H = 0;
		int W = 0;
		int N = 0;
		int ans = 0;
		int rNum = 0; 
		int floor = 0;
		 
		
		for( int i = 0 ; i < T ; i++ ) {
			
			StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
			
			H = Integer.parseInt(tz.nextToken());
			W = Integer.parseInt(tz.nextToken());
			N = Integer.parseInt(tz.nextToken());
			
			if (N%H == 0 ) {
				floor = H;
				rNum = N/H;
			} else {
				floor = N%H;
				rNum = (N/H) + 1;
			}
			ans = (floor * 100) + (rNum);
			
			System.out.println(ans);
		}

	}

}
