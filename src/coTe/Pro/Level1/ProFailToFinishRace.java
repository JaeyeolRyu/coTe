package coTe.Pro.Level1;

import java.util.Arrays;

class ProFailToFinishRace {
	
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		String ans = solution(participant, completion);
		
		System.out.println(ans);
		
	}
    public static String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < participant.length-1; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        return participant[participant.length-1];
    }
}