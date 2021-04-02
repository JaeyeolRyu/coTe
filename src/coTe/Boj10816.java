package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj10816 {
	static LinkedList<Integer> list = new LinkedList<>();
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}

		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		int num;
		
		st = new StringTokenizer(br.readLine());
		
		for(int j = 0 ; j < M ; j++) {
			
			num = Integer.parseInt(st.nextToken());
			sb.append(binary(num)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static int upper(int num) {
		
		int first = 0;
		int last = arr.length;
		int mid = 0;
		
		while(first < last) {
			
			mid = (first+last)/2;
			
			if(arr[mid] <= num) {
				
				first = mid + 1 ;
				
			}else {
				
				last = mid;
			}	
			
		}
		
		return first; 
	}
	
	public static int lower(int num) {
		
		int first = 0;
		int last = arr.length;
		int mid = 0;
		
		while(first < last) {
			
			mid = (first+last)/2;
			
			if(arr[mid] >= num) {
				
				last = mid ;
				
			}else {
				
				first = mid + 1;
			
			}
			
		}
		
		return first; 
		
		
	}
	public static int binary(int num) {
		
		int high = upper(num);
		int low  = lower(num);
		
		return high - low ;
		
		
	}
	
}
