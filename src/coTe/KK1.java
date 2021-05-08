package coTe;

class KK1 {

    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
        	
        	if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        		sb.append(s.charAt(i));
        	} else if(s.charAt(i) == 'z') {
        		sb.append(0);
        		i+=3;
        	} else if(s.charAt(i) == 'o') {
        		sb.append(1);
        		i+=2;
        	} else if(s.charAt(i) == 't') {
        		if(s.charAt(i+1) == 'w') {
            		sb.append(2);
            		i+=2;
        		}else {
        			sb.append(3);
        			i+=4;
        		}
        		
        	} else if(s.charAt(i) == 'f') {
        		if(s.charAt(i+1) == 'o') {
            		sb.append(4);
            		i+=3;
        		}else {
        			sb.append(5);
        			i+=3;
        		}
        		
        	} else if(s.charAt(i) == 's') {
        		if(s.charAt(i+1) == 'i') {
            		sb.append(6);
            		i+=2;
        		}else {
        			sb.append(7);
        			i+=4;
        		}
        		
        	} else if(s.charAt(i) == 'e') {
        		sb.append(8);
        		i+=4;
        	 }else if(s.charAt(i) == 'n') {
        		sb.append(9);
         		i+=3;
        	}
        	
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}