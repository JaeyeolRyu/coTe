package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EarthDis {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		
		for ( int i = 0 ; i < T ; i++ ) {
			
			StringTokenizer tz = new StringTokenizer(br.readLine()," ");
			
			x = Integer.parseInt(tz.nextToken());
			y = Integer.parseInt(tz.nextToken());
			
			System.out.println(cal(x, y));
			
		}

	}

	public static int cal(int x, int y) {
		
		int dis = y - x;
		int count = (int)Math.sqrt(dis);
		int res = 0;
	
		if( dis == count * count) {
			res = (2 * count) - 1;
		} else if ( dis <= count * (count + 1)  ) {
			res = (2 * count) ;
		} else {
			res = (2 * count) + 1;
		}
		
		return res;
		
	}

}
