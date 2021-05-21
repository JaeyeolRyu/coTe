package coTe.Pro;

class ProMaxAndMin {
    public String solution(String s) {
        String answer = "";
        
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
        
        for(String str : s.split(" ")) {

        	min = Math.min(Integer.parseInt(str), min);
        	max = Math.max(Integer.parseInt(str), max);
        	
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}
