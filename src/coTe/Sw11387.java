package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw11387 {
	
	static double sum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < T+1 ; i++) {
			
			sum = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken()); 
			int L = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			sb.append("#" + i + " " + (int)damage(D,L,N)).append("\n");
		}

		System.out.println(sb);
	}

	public static double damage(int D, int L, int N ) { 
		
		for( int i = 0 ; i < N ; i++) {
			sum += D*(1+(i*L/100.0));
		}
		return sum;
	}
}
