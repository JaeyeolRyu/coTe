package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquarePoint {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [][] arr = new int[3][2];
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < 3 ; i++) {
			
			StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = Integer.parseInt(tz.nextToken()); 
			arr[i][1] = Integer.parseInt(tz.nextToken());
			
		}
		
		if(arr[0][0] == arr[1][0]) {
			x = arr[2][0];
		} else if(arr[1][0] == arr[2][0]) {
			x = arr[0][0];
		} else {
			x = arr[1][0];
		}
		
		if(arr[0][1] == arr[1][1]) {
			y = arr[2][1];
		} else if(arr[1][1] == arr[2][1]) {
			y = arr[0][1];
		} else {
			y = arr[1][1];
		}
		
		System.out.println(x + " " + y);
	}

}
