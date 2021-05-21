package coTe.Pro;

import java.util.Arrays;
import java.util.Comparator;

class KakaoFileArray2 {
    public String[] solution(String[] files) {

    	Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				String[] firstFile  = detachFile(o1);
				String[] secondFile = detachFile(o2);
				
				String firstHead  = firstFile[0].toUpperCase();
				String secondHead = secondFile[0].toUpperCase();
				if(firstHead.equals(secondHead)) {
					
					int firstBody  = Integer.parseInt(firstFile[1]); 
					int secondBody = Integer.parseInt(secondFile[1]);
					
					return firstBody-secondBody;
					
				}
				return firstHead.compareTo(secondHead);
			}
		});
    	
    	
    	String[] answer = files;
        return answer;
    } 
    
    public String[]	detachFile(String file) {
    	
    	String[] detached = new String[3];
    	
    	String head = "";
    	String body = "";
    	String tail	= "";
    	
       	int idx = 0;
    	for( ; idx < file.length(); idx++) { //head찾기
    		char tempChar = file.charAt(idx);
    		
    		if((tempChar >= 'a' && tempChar <= 'z') || (tempChar >= 'A' && tempChar <='Z') || tempChar == '-' || tempChar == '.' || tempChar == ' ') {
    			head += tempChar;
    		} else {
    			break;
    		}
    	}

    	for( ; idx < file.length(); idx++ ) { // body찾기
    		char tempChar = file.charAt(idx);
    		if(tempChar >= '0' && tempChar <= '9') {
    			body += tempChar;
    			if(body.length() == 5) {
    				idx++;
    				break;
    			}
    		} else {
    			break;
    		}
    	}
    	
		tail = file.substring(idx);
    	
    	detached[0] = head;
    	detached[1] = body;
    	detached[2] = tail;

    	return detached;
    }
    
}
