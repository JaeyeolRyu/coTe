package coTe;

public class Solution {
	 
	public String solution(String new_id) {

		String answer = "";
		
		String step1 = new_id.toLowerCase(); // 1단계
	
		
		char[] arr = step1.toCharArray();    // 2단계
		StringBuilder sb = new StringBuilder();
		for(char i : arr) {
			
			if((i <= 'z' && i >= 'a') || (i <= '9' && i >= '0') || i == '.' || i == '_' || i == '-') {
				
				sb.append(i);
			}
			
		}
		String step2 = sb.toString(); 
		
		
		String step3 = step2.replace("..", "."); //3단계
		while(step3.contains("..")) {
			
			step3 = step3.replace("..", ".");
		}
		
		
		String step4 = step3;   // 4단계
		if (step4.length() > 0) {
			if(step4.charAt(0) == '.' ) {
				step4 = step4.substring(1);
			}
		}
		
		if (step4.length() > 0) {
			if(step4.charAt(step4.length()-1) == '.') {
				step4 = step4.substring(0, step4.length() - 1);
				
			}
		}
		
		
		String step5 = step4; 	// 5단계
		
		if(step5.isEmpty()) {
			step5 = "a";
		}
		
		
		String step6 = step5; // 6단계
		
		if( step6.length() >= 16) {
			
			step6 = step6.substring(0, 15);
			
			if(step6.charAt(step6.length()-1) == '.' ) {
				
				step6 = step6.substring(0,step6.length()-1);
			}
			
		}
			
		
		StringBuilder step7 = new StringBuilder();	//7단계
		step7.append(step6);
		
		if(step7.length() <= 2) {
			
			while(step7.length() != 3) {
				
				step7.append(step7.charAt(step7.length()-1));
			}
		}
		
		answer = step7.toString();
		
        return answer;

	}

}
