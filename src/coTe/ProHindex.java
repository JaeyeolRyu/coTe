package coTe;

import java.util.Arrays;

class ProHindex {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        if( citations[0] > citations.length) {
        	return citations.length;
        }
        
        for(int i = 0; i < citations.length; i++) {
        	
        	if(citations[i] >= citations.length-i) {
        		
        		answer = Math.max(citations.length-i, answer);
        		break;
        	} 

        }
        
        return answer;
    }
}