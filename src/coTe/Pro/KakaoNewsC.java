package coTe.Pro;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class KakaoNewsC {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        String pattern = "^[A-Z]*$";
        
        for(int i = 0 ; i < str1.length()-1; i++) {
        	
        	str1List.add(str1.substring(i,i+2));
        }
        
        for(int i = 0 ; i < str2.length()-1; i++) {
        	
        	str2List.add(str2.substring(i,i+2));
        }
        
        for(int i = 0 ; i < str1List.size(); i++) {
        	
        	if(!Pattern.matches(pattern, str1List.get(i))) {
        		str1List.remove(i);
        		i--;
        	}
        	
        }
        
        for(int i = 0 ; i < str2List.size(); i++) {
        	
           	if(!Pattern.matches(pattern, str2List.get(i))) {
        		str2List.remove(i);
        		i--;
        	}
        	
        }
        
        answer = compareStr(str1List, str2List);
        

        return answer;
    }
    
    public int compareStr (List<String> str1List, List<String> str2List ) {
    	
    	if(str1List.size() == 0 && str2List.size() ==0) {
    		return 65536;
    	}
    	
    	int intersection = 0;
    	int union = 0;
    	double answer = 0;
    	
    	for(int i = 0 ; i < str1List.size(); i++) {
    		
    		if(str2List.contains(str1List.get(i))) {
    			
    			intersection++;
    			union++;
    			str2List.remove(str2List.indexOf(str1List.get(i)));
    			str1List.remove(i);
    			i--;
    			
    		}
    		
    	}
    	
    	union += str1List.size()+str2List.size();
    	System.out.println(intersection);
    	System.out.println(union);
    	System.out.println((double)intersection/union);
    	answer = ((double)intersection/union)*65536;
    	
    	return (int)answer;
    	
    }
    
}
