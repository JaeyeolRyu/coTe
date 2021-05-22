package coTe.Pro.Kakao;

import java.util.ArrayDeque;
import java.util.Deque;

class KakaoBracket {
	
	static StringBuilder sb = new StringBuilder();
	static Deque<Character> dq = new ArrayDeque<Character>();
	
	public static void main(String[] args) throws Exception {
		
		String p = "()))((()";
		
		String ans = solution(p);
		
		System.out.println(ans);
		
	}
	
	
    public static String solution(String p) {
        String str = p;
        int bracketCnt = 0;
        
        for(int i = 0; i < str.length(); i++) {
        	
        	if(str.charAt(i) == '(') {
        		bracketCnt++;
        	}else {
        		bracketCnt--;
        		if(bracketCnt < 0) {
        			break;
        		}
        	}
        }
        
        if(bracketCnt == 0) {  // 완전한 문자열일 경우 여기서 return 된다.
        	return str;
        } else {
        	
        	for(int i = 0; i < str.length(); i++) {
        		dq.add(str.charAt(i));
        	}
        	
        	recursive();
        }  
        
        return sb.toString();
    }
    
    public static void recursive (){
    	
    	int bracketCnt = 0;
    	String u = "";

    	while(!dq.isEmpty()){
    		
    		if(dq.peekFirst() == '(') {
    			bracketCnt++;
        	} else {
        		bracketCnt--;
        	}
    		u += dq.pollFirst();
    		
    		if(bracketCnt == 0) {
    			
    			if(check(u)) {
    				sb.append(u);
    				recursive();
    			} else {
    				sb.append("(");
    				recursive();
    				sb.append(")");
    				u = u.substring(1, u.length()-1);
    				sb.append(reverse(u));
    				
    				
    			}
    			
    		}
    		
    	}

    }
    
    public static boolean check(String str) {
    	
    	int basketCnt = 0;
    	
    	for(int i = 0 ; i < str.length(); i++) {
    		
    		if(str.charAt(i) == '(') {
    			basketCnt++;
    		} else {
    			basketCnt--;
    		}
    		
			if(basketCnt < 0) { // u가 잘못된 괄호
    			return false;
    		}
    	}
    	
    	return true;
    	
    }
    
    public static String reverse(String u) {
    	
    	String str = u.replace(")", "0").replace("(", ")").replace("0", "(");
    	
    	return str;
    }
    
}