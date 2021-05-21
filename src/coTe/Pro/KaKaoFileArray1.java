package coTe.Pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class KaKaoFileArray1 {
	
	static ArrayList<Map<Integer, String>> sortList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		String[] files = {"foo 9.txt","FOO9.txt", "Foo9 .txt", "foo010bar020.zip","F-15","a-00000"};
		String[] ans = solution(files);
		
		System.out.println(Arrays.toString(ans));
	}
	
	
    public static String[] solution(String[] files) {
        String[] answer = {};
        
        for(String str : files) {
        	
        	String head = "";
        	String body = "";
        	String tail = "";
        	int idx = 0;
        	for(idx = 0 ; idx < str.length(); idx++) { //head찾기
        		
        		char tempChar = str.charAt(idx);
        		
        		if((tempChar >= 'a' && tempChar <= 'z') || (tempChar >= 'A' && tempChar <='Z') || tempChar == '-' || tempChar == '.' || tempChar == ' ') {
        			head += tempChar;
        		} else {
        			break;
        		}
        	}
        	int i = 0;
        	for( i = idx; i < str.length(); i++ ) { // body찾기
        		char tempChar = str.charAt(i);
        		if(tempChar >= '0' && tempChar <= '9') {
        			body += tempChar;
        			if(body.length() == 5) {
        				i++;
        				break;
        			}
        		} else {
        			break;
        		}
        	}
        	
    		tail = str.substring(i);
    		
//        	System.out.println("헤드: " + head + " 바디: " + body + " 꼬리: " +tail);
        	sortingHead(head, body, tail);
        	
        }
        
        answer = new String[sortList.size()];


        for(int i = 0 ; i < answer.length ; i++) {
        	
        	answer[i] = sortList.get(i).get(1)+sortList.get(i).get(2)+sortList.get(i).get(3);       	
        }
        
        return answer;
    }
    
    public static void sortingHead(String head, String body, String tail) {
    	Map<Integer,String> nameMap = new HashMap<Integer, String>();
    	if(sortList.isEmpty()) {
    		nameMap.put(1, head);
    		nameMap.put(2, body);
    		nameMap.put(3, tail);
    		sortList.add(nameMap);
    		return;
    		
    	} else {
    		for(int i = 0; i < sortList.size(); i++ ) {
    			int headLength = 0;
    			boolean isSame = false;
    			boolean isLong = false;
    			String inputHead = head.toUpperCase();
    			String compareHead = sortList.get(i).get(1).toUpperCase();
    			System.out.println(i);
    			System.out.println("비교인덱스 " + compareHead + "  길이 " + compareHead.length());
    			System.out.println("삽입인덱스 " + inputHead + "  길이 " + inputHead.length());
    			if(inputHead.equals(compareHead)) {
					sortingBody(head,body,tail,i);
					return;
    			}
    			
    			if(inputHead.length() < compareHead.length()) { //비교인덱스가 커서 true
    				headLength = inputHead.length();
    				isLong = true;
    			} else {
    				headLength = compareHead.length();
    				
    			}

				for(int j = 0; j < headLength; j++) {
					
					if(inputHead.charAt(j) == compareHead.charAt(j)) {
						
						continue; // 같으면 다음문자열 확인위해 continue;
						
					} else if(inputHead.charAt(j) > compareHead.charAt(j) ) {
						
						break; // 들어온값의 헤드가 크므로 다음인덱스의 헤드와 비교하기위해 break;
						
					} else { //기존인덱스에 있던 값이 큼.
			    		nameMap.put(1, head);
			    		nameMap.put(2, body);
			    		nameMap.put(3, tail);
			    		sortList.add(i,nameMap);
			    		return;
					}
					
				}
    			
				if(isSame&&isLong) {
					nameMap.put(1, head);
		    		nameMap.put(2, body);
		    		nameMap.put(3, tail);
		    		sortList.add(i,nameMap);
		    		return;
				}
				
    		} // 처리안됌 즉 기존 인덱스값들 다확인한 것보다 크다는 뜻이니 맨뒤에다가 삽입
    		
    		nameMap.put(1, head);
    		nameMap.put(2, body);
    		nameMap.put(3, tail);
    		sortList.add(nameMap);
    		return;
    		
    	}

    }
    
    public static void sortingBody(String head, String body, String tail, int idx) { //헤드부분이 같으면 옴.
    	Map<Integer,String> nameMap = new HashMap<Integer, String>();
    	for(int i = idx ; i < sortList.size(); i++) {
    		 
    		int inputBody = Integer.parseInt(body);
    		int compareBody = Integer.parseInt(sortList.get(i).get(2));

    		if(inputBody < compareBody) {
    			
        		nameMap.put(1, head);
        		nameMap.put(2, body);
        		nameMap.put(3, tail);
        		sortList.add(i,nameMap);
    			return;
    		}
    	}
    								//마지막까지 다돌았는데 값이더 크므로 맨 뒤에다가 삽입.
		nameMap.put(1, head);
		nameMap.put(2, body);
		nameMap.put(3, tail);
		sortList.add(nameMap);
		return;
    }

}