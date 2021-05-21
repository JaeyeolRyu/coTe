package coTe.Pro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KakaoOpenChat {
	
	List<String> accessList = new ArrayList<>(); // 출입순서
	Map<String, String> idMap = new HashMap<String, String>(); // id와 nickname 저장 용도.
	
    public String[] solution(String[] record) {
        String[] answer = {};
        
        for(String str : record) {
        	String[] infoArr = str.split(" ");
        	
        	switch (infoArr[0]) {
			case "Enter":
				accessList.add(infoArr[1] +" "+ infoArr[0]);
				idMap.put(infoArr[1], infoArr[2]);
				break;
			case "Leave":
				accessList.add(infoArr[1] +" "+ infoArr[0]);
				break;
			case "Change":
				idMap.put(infoArr[1], infoArr[2]);
				break;
			}
        	
        }
        idMap.put("Enter", "님이 들어왔습니다.");
        idMap.put("Leave", "님이 나갔습니다.");
        
        answer = new String[accessList.size()];
        
        for( int i = 0 ; i < accessList.size(); i++ ) {
        	
        	String[] tempArr = accessList.get(i).split(" ");
        	
        	answer[i] = idMap.get(tempArr[0]) + idMap.get(tempArr[1]);
        	
        }
        	        	
        return answer;
    }

}