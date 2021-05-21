package coTe.Pro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortDis {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(tz.nextToken());
		int y = Integer.parseInt(tz.nextToken());
		int w = Integer.parseInt(tz.nextToken());
		int h = Integer.parseInt(tz.nextToken());
		int a = w - x;
		int b = h - y;
		
		if (a > x - 0 ) {
			a = x;
		}
		
		if (b > y - 0 ) {
			b = y;
		}
		
		if( a <= b ) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}

	}

}
