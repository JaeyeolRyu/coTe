package coTe;

import java.util.ArrayList;
import java.util.List;

class KakaoCandidateKey {
	static String[][] relation;
	static List<String> successKey = new ArrayList<String>();
	static boolean[] visit;
	static int col;
	static int row;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		
//		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		String[][] relation = {{"a","aa"},{"aa","a"},{"a","a"}};
		
		int answer = solution(relation);
		
		System.out.println(answer);
	}
	
    public static int solution(String[][] relations) {
        
    	relation = relations;
    	visit = new boolean[relation.length];
    	int answer = 0;
    	
    	col = relation[0].length;
    	row = relation.length;
    	
    	for(int i = 1; i < col+1; i++) {

			int[] tempArr = new int[i];
//    		System.out.println(i + "개 조합---------");
			keyCombination(i,0,0,tempArr);
    		
    	}
    	
    	answer = cnt;
    	
    	return answer;
    }
    public static void keyCombination(int rowCnt, int depth, int target, int[] tempArr) { //1개 2개 3개 조합만드는곳
    	
    	if(rowCnt == 0) {
    		
    		if(!successKey.isEmpty()) { // 후보키로 선정된키들과 겹치는지 확인
    			
    			for(int i = 0; i < successKey.size(); i++) {
    				
    				String[] checkArr = successKey.get(i).split("");
    				int checkCnt = 0;
    				for(int j = 0; j < tempArr.length; j++) {
    					
    					for(String str : checkArr) {
    						
    						if( tempArr[j] == Integer.parseInt(str)) {
    							checkCnt++;
    						}
    						
    					}

    				}
					if(checkCnt == checkArr.length) {
						return;
					}
    			}
    		}
    			
    		findCandidateKey(tempArr);
    		return;
    	} else if(target == col) {
    		return;
    	}else {
    		
    		tempArr[depth] = target;
			keyCombination(rowCnt-1, depth+1, target+1, tempArr);
			keyCombination(rowCnt, depth, target+1,tempArr);
			
    	}
    	
    }
    
    public static void findCandidateKey(int[] tempArr) { //조합된 컬럼들을 String배열에 넣어 비교하는 메소드
    	
    	String[] combKey = new String[row];
    	
    	for(int i = 0 ; i < row; i++) {
    		
    		combKey[i] = "";
    		for(int j = 0 ; j < tempArr.length; j++) {
    			
    			combKey[i] += relation[i][tempArr[j]]+" ";
    		}
    	}
//    	System.out.print(" 0값: " + combKey[0]);
//    	System.out.print(" 1값: " +combKey[1]);
//		System.out.print(" 2값: " + combKey[2]);
//		System.out.print(" 3값: " +combKey[3]);
//		System.out.print(" 4값: " +combKey[4]);
//		System.out.println(" 5값: " +combKey[5]);
		
    	for(int i = 0 ; i < row; i++) {

    		for(int j = i+1; j < row; j++) {
    			
    			if(combKey[i].equals(combKey[j])) { // 키값이 같으면 return;
    				return;
    			}
    		}
    		
    	}
    							// 여기 왔으면 후보키로써 조건 만족한 상태
    	String makeSuccessKey ="";
    	for(int i = 0 ; i < tempArr.length; i++) {
    		makeSuccessKey += String.valueOf(tempArr[i]);// 후보키로 선정된 애들 넣기
    	}
//    	System.out.println("후보키값 : " + makeSuccessKey);
    	successKey.add(makeSuccessKey);
    	cnt++;
    	
    }

}