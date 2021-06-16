package coTe.Pro.Level4;

import java.util.Arrays;

class ProFourFundamentalOperation {
	static int[][] maxDP;
	static int[][] minDP;
	
	public static void main(String[] args) {

		String[] arr = { "1", "-", "3", "+", "5", "-", "8"};
		
		int answer = solution(arr);

		System.out.println(answer);

	}

	public static int solution(String arr[]) {
		
		maxDP = new int[(arr.length+1)/2][(arr.length+1)/2];
		minDP = new int[(arr.length+1)/2][(arr.length+1)/2];
		
		for(int i = 0; i < (arr.length+1)/2; i++) {
			Arrays.fill(maxDP[i], -987654321);
			Arrays.fill(minDP[i], 987654321);
		}
		
		for(int i = 0 ; i < arr.length; i+=2) {
			maxDP[i/2][i/2] = Integer.parseInt(arr[i]); 
			minDP[i/2][i/2] = Integer.parseInt(arr[i]);
		}
		
		for(int len = 1; len < (arr.length+1)/2; len++ ) {
			
			for(int i = 0 ; i + len < (arr.length+1)/2; i++) {
				
				int j = i + len;
				
				for(int k = 0; k < len; k++) {
					
					if(arr[2*(i+k)+1].equals("-")) {
						
						maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][i+k] - minDP[i+k+1][j]);
						minDP[i][j] = Math.min(minDP[i][j], minDP[i][i+k] - maxDP[i+k+1][j]);
								
					} else {
						
						maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][i+k] + maxDP[i+k+1][j]);
						minDP[i][j] = Math.min(minDP[i][j], minDP[i][i+k] + minDP[i+k+1][j]);
						
					}
					
				}
				
			}
			
		}
		
		for(int i = 0; i <(arr.length+1)/2; i++ ) {
			
			for(int j = 0; j <(arr.length+1)/2; j++ ) {
				
				System.out.println(i+" "+j + "  max값 = " + maxDP[i][j] );
				System.out.println(i+" "+j + "  min값 = " + minDP[i][j] );
				
			}
			
			
		}
		
		
		
		return maxDP[0][(arr.length-1)/2];
	}

}