package coTe;

class ProIntactSquare {
    public long solution(int w, int h) {
        
    	long answer = 1;
    	long totalNum = (long)w*h;
    	
    	int x = Math.max(w, h);
    	int y = Math.min(w, h);
    			
    	int gcd = gcd(x,y);

        answer = totalNum - (x/gcd + y/gcd - 1)*gcd;
    	    	
        return answer;
    }
    
    public int gcd(int a, int b) { 
    	
    	if(a%b == 0) {
    		return b;
    	}
    	
    	return gcd(b, a%b);
    }
    
}