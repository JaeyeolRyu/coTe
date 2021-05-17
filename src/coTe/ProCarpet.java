package coTe;

class ProCarpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1 ; i <= yellow; i++) {
        	
        	if(yellow%i == 0) {
        		
               	int isBrown =( 8+(i-1)*2 + 2*((yellow/i)-1)); 
               	
               	if(isBrown == brown) {
               		
               		answer[0] = yellow/i + 2;
               		answer[1] = i + 2;
               	
               		break;
               	}
        	}
        	
        }
        
        return answer;
    }
}