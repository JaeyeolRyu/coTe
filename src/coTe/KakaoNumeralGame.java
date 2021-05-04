package coTe;

class KakaoNumeralGame {
    
    public static void main(String[] args) {
    	
    	int n = 2;
    	int t = 4;
    	int m = 2;
    	int p = 1;
    	
    	String answer = solution(n, t, m, p);
    	System.out.println(answer);
    	
    }
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        
        char[] numeralSystem = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	int turnIdx = 1;
    	int num = 0;
    	int tubeTurn = p%m;
    	while(true) {
    		
    		int tempNum = num;
    		String tempStr = "";
			if(tempNum == 0) {
				tempStr = "0";
			} 
    		
    		while(tempNum > 0) {
    			tempStr += numeralSystem[tempNum%n];
    			tempNum /= n;
    		}
    		
    		for(int i = tempStr.length() ; i > 0; i--) {
    			if(turnIdx%m==tubeTurn ) {
    				answer += tempStr.charAt(i-1);
    				if(answer.length() == t) {
    					return answer;
    				}
    			}
    			turnIdx++;
    		}
    		num++;	
    	}
        
    }
    

}