package coTe.Pro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class KaKaoRankingSearch {
	
	static HashMap<String, List<Integer>> map = new HashMap<>();
	static StringBuilder sb;
	static int[] answer;
	
	public static void main(String[] args) {
		
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
		int[] ans = solution(info, query);
		
		for(int cnt : ans) {
			System.out.println(cnt);
		}
	}
	
    public static int[] solution(String[] info, String[] query) {
        
    	answer = new int[query.length];

    	setInfo(info);
    	procQuery(query);
        
        return answer;
    }
    
    public static void setInfo(String[] info) {

    	for(String str : info) {
    		
    		String [] infoData = str.split(" ");
 
    		dfs("", 0, infoData);
    		
    	}
    	
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()){
            String key=it.next();
            List<Integer> list = map.get(key);
            Collections.sort(list);
            
        }
    }
    
    public static void dfs(String str, int depth, String[] info) {
    	
    	if(depth==4) {
       		if(!map.containsKey(str)) {
    			List<Integer> list = new ArrayList<>();
    			list.add(Integer.parseInt(info[depth]));
    			map.put(str, list);
    			
    			return;
    		} else {
    			map.get(str).add(Integer.parseInt(info[depth]));
    			return;
    		}
    		
    	} else {
    		
    		dfs(str+info[depth], depth+1, info);
    		dfs(str+"-", depth+1, info);
    	}
    	
    }
    
    public static void procQuery(String[] query) {

    	for(int i = 0; i < query.length; i++) {
    		String tempStr = "";
    		String[] queryData = query[i].split(" ");
    		for(int j = 0; j < queryData.length-1; j++) {
    			if("and".equals(queryData[j])) {
    				continue;
    			} else {
    				tempStr += queryData[j] ;
    			}

    		}
    		answer[i] = search(tempStr, Integer.parseInt(queryData[queryData.length-1]));
    	}
    	
    }
    
    public static int search(String query, int idxNum ) {
    	if(!map.containsKey(query)) {
    		return 0;
    	} else {
    		
    		List<Integer> list = map.get(query);
  //원래 Collections.sort썻던 위치
    		int first = 0;
    		int mid = 0;
    		int last = list.size()-1;
    		
    		while(first <= last) {
    			
    			mid = (first+last)/2;
    			
    			if(idxNum <= list.get(mid)) {
    				
    				last = mid-1;
    				
    			} else {
    				first = mid+1;
    			}
   
    		}

    		return list.size()-first;
    	}
    	
    }
    
}