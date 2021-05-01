package coTe;; 

class Solution {
	static String[][] relation;
	static boolean[] successKey;
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
    	successKey = new boolean[relation.length];
    	visit = new boolean[relation.length];
    	int answer = 0;
    	
    	col = relation[0].length;
    	row = relation.length;
    	
    	for(int i = 1; i < col; i++) {
    		int tempCnt = 0;
    		for(boolean remainCol : successKey ) { // 후보키 선정되지 않은 컬럼의 갯수파악
    			if(!remainCol) {
    				tempCnt++;
    			}
    		}
    		if(i <= tempCnt) {	// 후보키 선정되지 않은 컬럼이 조합할 키 갯수보다 많으면 keyCombination들어감.
    			int[] tempArr = new int[i];
        		keyCombination(i,0,tempArr);
    		} else {
    			break;
    		}
    			
    	}
    	answer = cnt;
    	
    	return answer;
    }
    public static void keyCombination(int rowCnt, int depth,int[] tempArr) { //1개 2개 3개 조합만드는곳
    	
    	if(rowCnt == depth) {
    		
    		findCandidateKey(tempArr);
    		return;
    	}
    	
    	for(int i = 0 ; i < col; i++) {
    		
    		if(!successKey[i] && !visit[i]) {
    			
    			tempArr[depth] = i;
    			visit[i] = true;
    			keyCombination(rowCnt, depth+1, tempArr);
    			visit[i] = false;
    			if(successKey[tempArr[0]]) { // 예를들어 1,2키가 조합된상태면 1,3 1,4...를 건너뛰기위한 조건식 
    				return;
    			}
    		}
    		
    	}
    	
    }
    
    public static void findCandidateKey(int[] tempArr) { //조합된 컬럼들을 String배열에 넣어 비교하는 메소드
    	
    	String[] combKey = new String[row];
    	
    	for(int i = 0 ; i < row; i++) {
    		
    		for(int j = 0 ; j < tempArr.length; j++) {
    			
    			combKey[i] += relation[i][tempArr[j]];
    		}
    	}
    	
    	for(int i = 0 ; i < row; i++) {
    		
    		for(int j = i+1; j < row; j++) {
    			
    			if(combKey[i] == combKey[j]) { // 키값이 같으면 return;
    				return;
    			}
    		}
    		
    	}
    										// 여기 왔으면 후보키로써 조건 만족한 상태
    	for(int num : tempArr) {
    		successKey[num] = true;	// 후보키로 선정된 컬럼들을 true로 바꾼다.
    	}
    	cnt++;
    	
    }
    

}