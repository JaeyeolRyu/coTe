package coTe;

class KakaoDial {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        if(hand.equals("right")) {
        	hand = "R";
        }else {
        	hand = "L";
        }
        
        int leftIdx = 10;
        int rightIdx = 12;
        int dial = 0 ;
        for(int i = 0 ; i < numbers.length; i++) {
        	
        	if(numbers[i] == 0 ) {
        		dial = 11;
        	} else {
        		dial = numbers[i];
        	}
        	
        	if(dial == 1 || dial == 4 || dial == 7) {
        		answer += "L";
        		leftIdx = dial;
        		continue;
        	} else if(dial == 3 || dial == 6 || dial == 9) {
        		answer += "R";
        		rightIdx = dial;
        		continue;
        	} else {
        		
        		int lDis = (Math.abs(dial-leftIdx)/3) + (Math.abs(dial-leftIdx)%3);
            	int rDis = (Math.abs(dial-rightIdx)/3) + (Math.abs(dial-rightIdx)%3);
            	
            	if(lDis == rDis) {
            		answer += hand;
            		if(hand.equals("R")) {
            			rightIdx = dial;
            		} else{
            			leftIdx = dial;
            		}
            	} else if( lDis > rDis ) {
            		
            		answer += "R";
            		rightIdx = dial;
            		
            	} else {
            		answer += "L";
            		leftIdx = dial;
            	}
        		
        	}
        
        }  
        
        return answer;
    }
}