package coTe.Pro.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class KakaoBadUser {

	static int INF = 987654321;
	static List<String> checkIdx = new ArrayList<String>();
	static List<String> canIdx = new ArrayList<>();
	static Map<String, Integer> cntMap = new HashMap<String, Integer>();
	static String[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		int ans = solution(user_id, banned_id);
		
//		Iterator<String> it = cntMap.keySet().iterator();
//		
//		while(it.hasNext()) {
//			
//			System.out.println(it.next());
//			
//		}
		
		
		System.out.println(ans);
	}
	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		StringBuilder sb;
		
		
		for (String str : banned_id) {

			sb = new StringBuilder();

			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) != '*') {

					sb.append(i);

				}

			}
			checkIdx.add(sb.toString());
		}
		
		String canStr = "";
		
		for (int i = 0; i < banned_id.length; i++) {
			canStr = "";
			
			for (int j = 0; j < user_id.length; j++) {

				if(user_id[j].length() != banned_id[i].length()) {
					continue;
				}
				
				String temp = user_id[j];
				
				int k = 0;
				for(k = 0; k < checkIdx.get(i).length(); k++) {
					int tempIdx = checkIdx.get(i).charAt(k) - '0';
					if(temp.charAt(tempIdx) != banned_id[i].charAt(tempIdx)) {
						
						break;
					}
					
				}
				
				if(k == checkIdx.get(i).length()) {
					
					canStr += String.valueOf(j);
					
				}
				
				
			}
			
			canIdx.add(canStr);

		}
		
		arr = new String[canIdx.size()][user_id.length];
		visit =  new boolean[canIdx.size()];
		for(int i = 0; i < canIdx.size(); i++) {
			
			Arrays.fill(arr[i], "");
			int idx = 0;
			for(String str : canIdx.get(i).split("")) {
				
				arr[i][idx] = str; 
				idx++;
			}
			
		}
		
		
		combination(banned_id.length, 0, new String[banned_id.length]);
		
		answer = cntMap.size();
		
		return answer;
	}
	
	public static void combination(int size, int depth, String[] answerArr ) {
		
		if(depth == size) {
			String[] tempArr = answerArr.clone();
			Arrays.sort(tempArr);
			
			for(int i = 1 ; i < tempArr.length; i++) {
				
				if(tempArr[i-1].equals(tempArr[i])) {
					return;
				}
			}
			
			cntMap.put(Arrays.toString(tempArr), 0);
			
			return;
		}
		
		for(int i = 0 ; i < arr[0].length; i++) {
			
			if(arr[depth][i].equals("")) {
				break;
			} else {
				answerArr[depth] = arr[depth][i];
				combination(size, depth+1, answerArr);
				
			}
			
		}
		
	}

}
