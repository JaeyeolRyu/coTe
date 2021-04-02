package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(tz.nextToken());
		int B = Integer.parseInt(tz.nextToken());
		int V = Integer.parseInt(tz.nextToken());
		double i = (double)(V-B)/(A-B);
		int ans = (int)Math.ceil(i);

		System.out.println(ans);
		
	}

}


