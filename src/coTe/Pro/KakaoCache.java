package coTe.Pro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class KakaoCache {
	
	static final int cacheHit = 1;
	static final int cacheMiss = 5;
    static int headNode = 0;
    static int tailNode = 1;
    static int cacheCnt = 0;
	static Map<String, Integer> LRUMap = new HashMap<>();
	static int cacheSize = 5;
	
//	public static void main(String[] args) throws Exception {
//		
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//		int cacheSize = 5;
//		
//		int answer = solution(cacheSize,cities);
//		
//		System.out.println(answer);
//	}
	
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
//		this.cacheSize = cacheSize;
        
        if(cacheSize ==0) {
        	return cities.length * cacheMiss;
        }
        
        for(int i = 0 ; i < cities.length; i++) {
        	
        	cities[i] = cities[i].toLowerCase();
        	
        }
        
        for(String str : cities) {
        	
        	put(str);
        	
        }

        answer = cacheCnt;
        return answer;
    }
    
    public static void put(String key) {
    	
    	if(LRUMap.containsKey(key)) { // 키가 있을경우
    		update(key);
    		cacheCnt += cacheHit;
    	} else {
    		add(key);
    		cacheCnt += cacheMiss;
    	}
    	
    }
    
    public static void add(String key) {
    	
    	if(LRUMap.size() < cacheSize) { // 캐시사이즈보다 작을때
    		LRUMap.put(key, ++headNode);
    		
    	} else { //같거나 큰상황
    		remove();
    		LRUMap.put(key, ++headNode);
    		
    	}
    	
    }
    
    public static void update(String key) {
    
    	if( LRUMap.get(key) == tailNode) { // 있는값이 tailNode일 경우
    		
    		LRUMap.put(key, ++headNode);
    		tailNode++;
    		
    	} else if( LRUMap.get(key) == headNode) { // headNode일경우
    		
    		return;
    		
    	} else { // middleNode일 경우

    		LRUMap.put(key, ++headNode);
    		
    	}
    		
    }
    
    public static void remove() {
    	
    	Iterator<String> it = LRUMap.keySet().iterator();
    	
    	while(it.hasNext()) {
    		String key = it.next();
    		if(LRUMap.get(key) == tailNode) {
				LRUMap.remove(key);
				tailNode++;
				return;
			} 
    	}
    			
		tailNode++;
		remove();
    	
    }
    
}