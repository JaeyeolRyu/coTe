package coTe.Pro.Kakao;

import java.util.HashMap;
import java.util.Map;

class KaKaoTakePicture {
	
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static int[] combArr = new int[8];
	static boolean[] visit = new boolean[8];
	static String[] data;
	static int cnt = 0;
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		
		int ans = solution(n, data);
		System.out.println(ans);
	}
	
    public static int solution(int n, String[] datas) {
   
    	data = datas;
    	
    	map.put("A", 0);
    	map.put("C", 1);
    	map.put("F", 2);
    	map.put("J", 3);
    	map.put("M", 4);
    	map.put("N", 5);
    	map.put("R", 6);
    	map.put("T", 7);
    	
    	int answer = 0;
    	combination(0);
    	answer = cnt;
    	
    	return answer;
    }
    
    
    
    
    
   public static void combination (int depth) {
	   
	   if(depth == friends.length) {
		   
		   if(check()) {
			   cnt++;
		   }
		   
		   return;
	   }

	   	for(int i = 0; i < friends.length; i++) {
	    	
	   		if(!visit[i]) {
	   			
	   			combArr[depth] = i;
	   			visit[i] = true;
	   			combination(depth+1);
	   			visit[i] = false;
				   
			}
			
	   	}
   	
   }
   
   public static boolean check() {
	   
	   for(int i = 0; i < data.length; i++) {
		   
		   for(String str : data) {
			   
			  int first  = combArr[map.get(String.valueOf(str.charAt(0)))];
			  int second = combArr[map.get(String.valueOf(str.charAt(2)))];
			  char sign = str.charAt(3);
			  int value = str.charAt(4) - '0' + 1;
			  
			  switch (sign) {
		
					case '=':
						
						if(Math.abs(first-second) != value) {
							return false;
						}
						
						break;
					case '<':
						
						if(Math.abs(first-second) >= value) {
							return false;
						}
						
						break;
					case '>':
						
						if(Math.abs(first-second) <= value) {
							return false;
						}
						
						break;
				}

		   }
		   
	   }
	   
	   return true;
   }
    
}