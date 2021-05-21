package coTe.Pro;

class SkillCheckTest2_1 {
    public String solution(String s) {
        String answer = "";
        
        int n = s.length();
        
        if(n%2 == 0) {
        	
        	answer = s.substring(n/2,(n/2)+1);
        	
        } else {
        	
        	answer = String.valueOf(s.charAt(n/2));
        	
        }
        
        return answer;
    }
}