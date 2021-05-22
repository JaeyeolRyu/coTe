package coTe.Pro.Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KaKaoGemShopping {
	static List<String> gemList = new ArrayList<String>();
	
//	public static void main(String[] args) throws Exception {
//		
//		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		int[] answer = solution(gems);
//		System.out.println(Arrays.toString(answer));
//	}
	
    public static int[] solution(String[] gems) {
    	int[] answer = new int[2];
    	int min = 100001;
    	for(int i = 0; i < gems.length; i++) {
    		
    		if(!gemList.contains(gems[i])) {
    			gemList.add(gems[i]);
    		}
    		
    	}
    	int gemCnt = gemList.size();
    	
    	Map<String,Integer> gemMap = new HashMap<>();
    	
    	for(int i = 0 ; i < gems.length; i++) {
    		
    		gemMap.put(gems[i], i);
    		if(gemCnt == gemMap.size()) {
    			
    			List<String> keySet = new ArrayList<>(gemMap.keySet());
    			
    			Collections.sort(keySet, (o1, o2) -> (gemMap.get(o1).compareTo(gemMap.get(o2))));
    			int start = gemMap.get(keySet.get(0)) + 1;
    			int end   = gemMap.get(keySet.get(gemMap.size()-1)) +1;
    			
    			
    			if(end-start < min ) {
    				answer[0] = start;
    				answer[1] = end;
    				min = end-start;
    			}
    			gemMap.remove(keySet.get(0));
    			
    		}
    	}
    	
        return answer;
    	
    }

}