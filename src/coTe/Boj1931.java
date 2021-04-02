package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1931 {

	static int[][] time;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		
		time = new int[N][2];
		
		for(int i = 0; i < N ; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
		
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {				
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				
				return o1[1]-o2[1];
			}
		});	
		
		proc(N);
		
	}

	public static void proc(int N) {
		int count = 0;
		int temp = 0;
		
		for(int i = 0; i < N ; i++) {
			
			if(temp <= time[i][0]) {
				temp = time[i][1];
				count++;	
				
			}
			

		}

		System.out.println(count);
	}
	
	
}
