package coTe.Pro.Kakao;

class KakaoDart {
	
	public static void main(String[] args) throws Exception {
	
		String str = "10D10S2T*";
		
		int ans = solution(str);
	
		System.out.println(ans);
	}
	
    public static int solution(String dartResult) {
        
    	int len = dartResult.length();
    	char[] arr = new char[len];
    	int[] score = new int[11];
    	int answer = 0;
        int prevIdx = 0;
    	int idx = 0;
        arr = dartResult.toCharArray();
        
    	for(int i = 0; i < arr.length; i++) {
    		
    		switch (arr[i]) {
			case 'S' : 
				score[idx] += idx;
				break;
			case 'D' : 
				score[idx] += (int)Math.pow(idx, 2);
				break;
			case 'T' : 
				score[idx] += (int)Math.pow(idx, 3);
				break;
			case '*' : 
				score[idx] *= 2;
				score[prevIdx] *= 2;
				break;
			case '#' : 
				score[idx] *= -1;
				break;
			default:
				prevIdx = idx;
				if(arr[i] == '1' && arr[i+1] == '0') {
					idx = 10;
					i++;
				} else {
					idx = arr[i] - '0';
				}
				
				break;
			}

    	}
    	
    	for(int i = 0 ; i < score.length; i++) {
    		answer += score[i];
    	}
    	
    	return answer;
    }
}