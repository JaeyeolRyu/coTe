package coTe.Pro.Level1;

class Solution {
	
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6) {
        	return false;
        }
        
        for(char c : s.toCharArray()) {
        	if(c >= '0' && c <= '9') {
        		continue;
        	}
        	return false;
        }
        
        return answer;
    }
}