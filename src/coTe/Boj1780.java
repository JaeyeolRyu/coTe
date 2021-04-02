package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780 {
	
	static int[][]	arr;
	static int a = 0;
	static int b = 0;
	static int c = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			
			st = new StringTokenizer(br.readLine());	
			
			for(int j = 0; j < N; j++) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
				
		}
		
		proc(0,0,N);
		
		System.out.println(a + "\n" + b + "\n" + c);
	}

	public static void proc(int x, int y, int num) {
		
		if(num == 1) {
		
			if(arr[x][y] == -1) {
				a++;
				return;
			} else if(arr[x][y] == 0) {
				b++;
				return;
			} else {
				c++;
				return;
			}
			
		}
		
		for(int i = x ; i < x + num ; i++) {
			
			for(int j = y ; j < y + num; j++) {
				
				if(arr[x][y] != arr[i][j]) {
					
						proc(x,y,num/3);
						proc(x,y+num/3,num/3);
						proc(x+num/3,y,num/3);
						proc(x+num/3,y+num/3,num/3);
						proc(x+(2*num/3),y,num/3);
						proc(x,y+(2*num/3),num/3);
						proc(x+(2*num/3),y+num/3,num/3);
						proc(x+num/3,y+(2*num/3),num/3);
						proc(x+(2*num/3),y+(2*num/3),num/3);
						return;
				}
					
			}	

		}
		
		if(arr[x][y] == -1) {
			a++;
		} else if(arr[x][y] == 0) {
			b++;
		} else {
			c++;
		}

	}
}
