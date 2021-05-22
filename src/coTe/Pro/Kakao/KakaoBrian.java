package coTe.Pro.Kakao;

class KakaoBrian {
	static StringBuilder sb = new StringBuilder();
	static boolean[] duplicationCheck = new boolean[26];
    
	public static void main(String[] args) throws Exception {
		
		String sentence = "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR";
		
		String ans = solution(sentence);
		
		System.out.println(ans);
	}
	
	public static String solution(String sentence) {
        
    	String answer = "invalid";
        //규칙1은 단어의 양끝이 비어있고, 안쪽은 다 채워져야함. 
        //규칙2는 무조건 갯수가 2개짜리임.
        //동일규칙을 한단어에 2번적용불가.
        //무조건 규칙1안에 규칙2 존재불가능
        char[] senArr = sentence.toCharArray();
        char lowerCase1  = '0';
        char lowerCase2	= '0';
//        int  lowerCharAt = 0;	
        int start = 0;
        boolean lowerFirst = true;
        
        for(int i = start ; i < senArr.length; i++) {
        	
        	if(senArr[i] >= 'a' && senArr[i] <= 'z') {
        		lowerCase1 = senArr[i];
    			
        		if(duplicationCheck[lowerCase1-'a']) { //소문자가 이미 나왔던 소문자이면 invalid
    				return "invalid";
    			}

        		if(lowerFirst) { //시작이 소문자인지 확인 용

        			int idx = rule2(senArr,lowerCase1,i);
        			i = idx;
        			start = idx+1; //문자열 시작부분을 저장해놓기위함.
        			lowerFirst = true; // 다 sb에 넣었으니 불린형 초기화
        			
        		} else { //else인 경우 소문자가 확인됐지만 맨앞이 소문자였던건 아니니 1 2 1+2 다가능성 있다.
        			
        			for(int j = i+1; j < senArr.length; j++) {
        				
        				if(senArr[j] == lowerCase1) { // 규칙1 or 규칙2
        					
        					if(j-2 == i) { // 규칙 1 규칙2 다 가능하지만 규칙1로 처리
        						int idx = rule1(senArr,start,i,lowerCase1);
        						i = idx;
        						start = idx+1;
        						break;
        					} else { // 2칸전에 같은 문자가 아니므로 규칙 2로처리
//        						if(j-i == 1) {
//        							return "invalid"; // 같은 소문자 2개가 연달아 나타나면 잘못된문자열이므로 invalid
//        						}
        						
        						for(int k = start; k < i; k++) { //여기선 기존 앞에있던 대문자열을 넣어주고 rule2로가야함
        							sb.append(senArr[k]);
        						}
        						int idx = rule2(senArr, lowerCase1, i);
        						i = idx;
        						start = idx+1;
        						break;
        					}
        					
        				} else if(senArr[j] >= 'a' && senArr[j] <= 'z') { //규칙 1(lowerCase1이 한개인경우) or 규칙 1+2일경우
        					lowerCase2 = senArr[j];
        					
        					if(j-i !=2) { // 첫번쨰 두번쨰 나온 소문자들의 거리가 2차이가 안나면 첫번쨰 소문자는 규칙1인 하나짜리.
        						
        						int idx = rule1(senArr, start, i, lowerCase1);
        						i = idx;
        						start = idx+1;
        						break;
        					}
        					
        					if(senArr[j+2] == lowerCase2) { // rule 1+2인경우
        						
        						int idx = rule12(senArr, lowerCase1, lowerCase2, start);
        						i = idx;
        						start = idx+1;
        						break;
        					}
		
        				}
        			}
        				
        		}
        		lowerFirst = true;
        	} else {
        		lowerFirst = false;
    			
        	}

        }
        
        for(int i = start; i < senArr.length; i++) {
        	sb.append(senArr[i]);
        }
        
        answer = sb.toString();
        
        answer = answer.replace("  ", " ");
        
        
        return answer;
    } 
    
    public static int rule1(char[] senArr, int start, int lowerCharAt, char lowerCase1) {	// rule1만 있는단어
    	
    	int endIdx = 0;
		int i = 0;
    	for( i = lowerCharAt; i < senArr.length; i+=2) {
			
			if(senArr[i] != lowerCase1) {
				endIdx = i; // lowerCase1이 안나온 idx
				break;
			}
		}
    	
		if(i >= senArr.length) {
			
			endIdx = i;
		}
			
		for(int j = start; j < endIdx; j++) {
			
			if( j == lowerCharAt-1 ) {
				sb.append(" ");
				sb.append(senArr[j]);
				continue;
			}
			
			if( senArr[j] == lowerCase1 ) {
				continue;
			}
			
			sb.append(senArr[j]);

		}
    	sb.append(" ");
		duplicationCheck[lowerCase1-'a'] = true;
		
		return endIdx-1;
    }
    
    public static int rule2(char[] senArr, char lowerCase, int lowerCharAt) { // rule2만 있는단어
    	
    	int idx = 0;
    	for(int i = lowerCharAt+1 ; i < senArr.length ; i++) {
    		
    		if(senArr[i] == lowerCase) { //규칙2일경우
    			
    			if(i-lowerCharAt == 1) { // 같은 소문자 2개가 연달아 나타나면 잘못된문자열이므로 invalid
    				System.out.println("invalid");
    				System.exit(0);
    			} else {
    				sb.append(" ");
    				for(int j = lowerCharAt+1; j < i ; j++) {
    					sb.append(senArr[j]);
    				}
    				sb.append(" ");
    				duplicationCheck[lowerCase-'a'] = true;
    				return i;
    			}
    			
    			
    		} else if(senArr[i] >= 'a' && senArr[i] <= 'z') { //규칙 1+2일경우 
    			char lowerCase2 = senArr[i];
    			
    			idx = rule12(senArr, lowerCase, lowerCase2, lowerCharAt);
    			return idx;
    		}
    		
    		
    	}
    	
    	//여기왔다는건 맨앞에 소문자가있지만 문자열끝까지 탐색해도 같은 소문자가 없다는 것이므로 invalid
    	System.out.println("invalid");
    	System.exit(0);
    	
    	return 0;
    }
    
    public static int rule12(char[] senArr, char lowerCase1, char lowerCase2, int start) {// rule1 과 rule2가 같이있는 단어
    	//lowerCase1이 규칙2번을 따라야함.
    	//lowerCase2가 규칙1번을 따라야함.
    	int endIdx = 0;
    	
    	for(int i = start+2; i < senArr.length; i+=2) {
    		if(senArr[i] == lowerCase1 ) {
    			endIdx = i;
    			break;
    		}
    		
    		if(senArr[i] != lowerCase2) { // 1+2조합은 규칙2사이에 규칙1이 간격 2씩 차이나게 들어있어야하는데 아니면 invalid
    			System.out.println("invalid");
    			System.exit(0);
    		}
    	}
    	
    	sb.append(" ");
    	for(int i = start+1 ; i < endIdx; i++) {
    		
    		if( senArr[i] == lowerCase2) {
    			continue;
    		}
    		sb.append(senArr[i]);
    	}
    	sb.append(" ");
    	
    	duplicationCheck[lowerCase1-'a'] = true;
    	duplicationCheck[lowerCase2-'a'] = true;

    	return endIdx;
    }
    
}