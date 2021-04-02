package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JeobjeomFail {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for ( int i = 0 ; i < T ; i++ ) {
			
			StringTokenizer tz = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(tz.nextToken());
			int y1 = Integer.parseInt(tz.nextToken());
			int r1 = Integer.parseInt(tz.nextToken());
			
			int x2 = Integer.parseInt(tz.nextToken());
			int y2 = Integer.parseInt(tz.nextToken());
			int r2 = Integer.parseInt(tz.nextToken());
			
			int ans = 0;
			
			double dis = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
			
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				ans = -1;
			} else if( x1 == x2 && y1 == y2 && r1 != r2 ) {
				ans = 0;
			} else if(dis == r2+r1 ) {
				ans = 1;
			} else if(dis < r2+r1) {
				ans = 2;
			} else if (dis + r1 == r2 || dis + r2 == r1) {
				ans = 1;
			} 
			
			
			
			
			else {
				ans = 0;
			}
			
			System.out.println(ans);

		}

	}

}
