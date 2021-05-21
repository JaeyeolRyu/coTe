package coTe.Pro;

//import java.util.Arrays;

class ProBitChange {
	
//	public static void main(String[] args) {
//		
//		long[] numbers = {2,7};
//		long[] ans = solution(numbers);
//		System.out.println(Arrays.toString(ans));
//		
//	}
	
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for(long temp : numbers) {
        	
    		long num = temp;
    		int pow = 0;
    		while(num >= 0) {
    			
    			if(num%2 == 0) {
    				answer[idx] = temp+(long)Math.pow(2, pow)-(long)Math.pow(2, pow-1);
    				break;
    			}
    			pow++;
    			num /= 2;
    			
    		}
    		
    		idx++;
        }
    		
        return answer;
    }
}