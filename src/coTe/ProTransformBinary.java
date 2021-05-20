package coTe;

class ProTransformBinary {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int transCnt = 0;
        int zeroCnt = 0;
        StringBuilder sb;
        while(!s.equals("1")) {
        	
        	sb = new StringBuilder();
        	String temp = s.replace("0", "");
        	zeroCnt += s.length()-temp.length();
        	int num = temp.length();
        	
        	while(num > 0) {
        		sb.append(num%2);
        		num /= 2;
        	}
        	
        	transCnt++;
        	s = sb.reverse().toString();
        }
        
        answer[0] = transCnt;
        answer[1] = zeroCnt;

        return answer;
    }
}