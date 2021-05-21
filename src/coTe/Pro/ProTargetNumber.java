package coTe.Pro;

class ProTargetNumber {
    
	boolean[] visit;
	int cnt = 0;
	public int solution(int[] numbers, int target) {
		visit = new boolean[numbers.length];
        int answer = 0;
        
        calc(numbers,target,0,0);
        
        answer = cnt;
        return answer;
    }
    
    public void calc(int[] numbers, int target, int calResult, int idx) {
    	
    	if(idx == numbers.length) {
    		
    		if(calResult == target) {
    			cnt++;
    		}
    		return;
    	}

		int num = numbers[idx];
		
		calc(numbers, target, calResult+num, idx+1);
		calc(numbers, target, calResult-num, idx+1);
    	
    }
}