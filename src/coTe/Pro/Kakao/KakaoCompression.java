package coTe.Pro.Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KakaoCompression {
	
	public static void main(String[] args) {

		String msg = "KAKAO";
		
		int[] answer = solution(msg);
		
		System.out.println(Arrays.toString(answer));
        
	}
    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        
        Map<String, Integer> dicMap = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        String tempStr = "";
        int dicIdx = 1;
        for(char c = 'A'; c <= 'Z'; c++ ) {
        	
        	dicMap.put(String.valueOf(c), dicIdx);
        	dicIdx++;
        }
        
        for(int i = 0 ; i < msg.length(); i++ ) {
        	
        	sb.append(msg.charAt(i));
        	
        	if(dicMap.containsKey(sb.toString())) {
        		tempStr = sb.toString();
        		
        		if(i == msg.length()-1) {
        			answerList.add(dicMap.get(tempStr));
        			break;
        		}
        		continue;
        	} 
        	// 여기 온거면 키가 없다는뜻
        	
        	answerList.add(dicMap.get(tempStr)); // 직전에 dicMap에 존재했던 키의 value값을 answerList 넣음.
        	
        	dicMap.put(sb.toString(), dicIdx++); // 다음글자까지 입력해놓은 stringbuilder를 map에 색인과 함께 저장함.
        	i--; 		//다음글자를 현재글자로 시작하기 위함.
        	sb = new StringBuilder();
        	
        }
 
        answer = new int[answerList.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}