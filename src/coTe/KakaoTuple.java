package coTe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KakaoTuple {
	
	public static void main(String[] args) {
		
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		int[] ans = solution(s);
	
		System.out.println(Arrays.toString(ans));
	}
    public static int[] solution(String s) {
        
    	int[] answer = {};
        
    	Map<String, Integer> cntMap	= new HashMap<>();
		String[] separation = s.replace("{", "").replace("}", "").split(",");
		
        for(String str : separation) {
        	int cnt = cntMap.getOrDefault(str, 0) + 1;
        	cntMap.put(str, cnt);
        }

//        List<String> keySetList = new ArrayList<>(cntMap.keySet());
//        Collections.sort(keySetList, (o1, o2) -> (cntMap.get(o2).compareTo(cntMap.get(o1)))); 
//        answer = new int[keySetList.size()];

        List<String> keySetList = new ArrayList<>(cntMap.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
        
			@Override
			public int compare(String o1, String o2) {
				
				return cntMap.get(o2) - cntMap.get(o1);
			}
		}); 
        answer = new int[keySetList.size()];
        
        for(int i = 0 ; i < keySetList.size(); i++) {
        	answer[i] = Integer.parseInt(keySetList.get(i));
        }
       	
        return answer;
    } 
    
}