	package coTe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class KakaoMenu {
	
	static StringBuilder sb;
	static List<HashMap<String, Integer>> menu = new ArrayList<>();
	static Queue<String> q = new LinkedList<String>();
	static int[] max;
	
    public static void main(String[] args) {
    	
    	String[] orders = {"XYZ", "XWY", "WXA"};
    	int[] course = {2,3,4};
    	
    	String[] ans = solution(orders, course);
    	System.out.println(Arrays.toString(ans));
    	
    }
    
    
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        max = new int[11];
        
        for(int i = 0 ; i < 11 ; i++ ) {
        	
        	menu.add(new HashMap<String,Integer>());
        	
        }
                
        for (String str : orders) {
        	
        	char[] arr = str.toCharArray();
        	Arrays.sort(arr);
        	combination(arr, 0, new StringBuilder());
        	
        }
        
        for(int cnt : course) {
        	
        	findAnswer(cnt);
        	
        }
        
        int temp = 0;
        answer = new String[q.size()];
        while(!q.isEmpty()) {
        	
        	answer[temp] = q.poll();
        	temp++;
        	
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static void combination(char[] arr, int depth, StringBuilder combine ) {
    	
    	if(arr.length == depth) {
    		
    		if(combine.length() >= 2) {
    			
    			if(!menu.get(combine.length()).containsKey(combine.toString())) {
    				menu.get(combine.length()).put(combine.toString(), 1);
    			} else {
    				int cnt = menu.get(combine.length()).get(combine.toString())+1;
    				menu.get(combine.length()).put(combine.toString(), cnt);
    				max[combine.length()] = Math.max(max[combine.length()], cnt);
    			}
    			
    		}
    		
    		return;
    	}
    	
    	combination(arr, depth+1, combine.append(arr[depth]));
    	combine.setLength(combine.length()-1);
    	combination(arr, depth+1, combine);
    	
    }
    
    public static void findAnswer(int cnt) {
    	
    	for(Map.Entry<String, Integer> entry : menu.get(cnt).entrySet()) {
    		
    		if(entry.getValue()>=2 && entry.getValue() == max[cnt]) {
    			q.add(entry.getKey());
    		}
    		
    	}
    	
    }
    
    
}