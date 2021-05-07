package coTe;

class KakaoLockAndKey {
	
	public static void main(String[] args) throws Exception {
		
		int[][] key =	{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock =  {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		boolean ans = solution(key,lock);
		
		System.out.println(ans);
		
		
	}
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int keySize = key.length;
        int lockSize = lock.length;
        
    	int[][] lockArr = new int[lockSize+(keySize*2)-2][lockSize+(keySize*2)-2];
    	
    	for(int i = keySize-1; i < lockSize+keySize-1; i++) {
    		for( int j = keySize-1 ; j < lockSize+keySize-1; j++) {
    			lockArr[i][j] = lock[i-keySize+1][j-keySize+1];
    		}
    	}
    	for(int i = 0; i<4; i++) {
    		int[][] keyArr = keyRotation(key);
    		key = keyArr;

    		if(combination(keyArr, lockArr)) {
    			return true;
    		}
    	}

        return answer;
    }
    
    public static int[][] keyRotation(int[][] key ) {  // rotCnt번 만큼 90도 회전

//    	System.out.println("------들어온 키값----");
//		System.out.println(key[0][0] + "" + key[0][1] + "" + key[0][2]);
//		System.out.println(key[1][0] + "" + key[1][1] + "" + key[1][2]);
//		System.out.println(key[2][0] + "" + key[2][1] + "" + key[2][2]);
//	
    	int keySize = key.length;
    	int[][] keyArr = new int[keySize][keySize];
    	
    	for(int i = 0 ; i < keySize; i++) {
    		for( int j = 0; j < keySize; j++ ) {
    			keyArr[i][j] = key[keySize-1-j][i];
    		}
    	}

//		System.out.println("-------로테이션후-------");
//		System.out.println(keyArr[0][0] + "" + keyArr[0][1] + "" + keyArr[0][2]);
//		System.out.println(keyArr[1][0] + "" + keyArr[1][1] + "" + keyArr[1][2]);
//		System.out.println(keyArr[2][0] + "" + keyArr[2][1] + "" + keyArr[2][2]);
//		
    	
    	return keyArr;
    }
    
    public static boolean combination(int[][] keyArr, int[][] lockArr) {
    	int keySize = keyArr.length;
    	int lockSize = lockArr.length;
    	int[][] lockKey = lockArr;
    	for( int i = 0 ; i < lockSize-keySize+1; i++ ) {
    		
    		for( int j = 0 ; j < lockSize-keySize+1; j++) {
    			for(int k = 0; k < keySize; k++	) {
    				for(int l = 0; l < keySize; l++) {
    					lockKey[i+k][j+l] += keyArr[k][l];
    				}
    			}

				if(checkPossibility(lockKey, keySize)) {
					return true;
				}
    			for(int k = 0; k < keySize; k++	) {
    				for(int l = 0; l < keySize; l++) {
    					lockKey[i+k][j+l] -= keyArr[k][l];
    				}
    			}
//    			System.out.println("-------초기화-------");
//    			System.out.println(lockKey[2][2] + "" + lockKey[2][3] + "" + lockKey[2][4]);
//    			System.out.println(lockKey[3][2] + "" + lockKey[3][3] + "" + lockKey[3][4]);
//    			System.out.println(lockKey[4][2] + "" + lockKey[4][3] + "" + lockKey[4][4]);
    		}
    	}
    	
    	return false;
    }
   
    public static boolean checkPossibility(int[][] lockKey, int keySize) {
    	
    	for(int i = keySize-1 ; i < lockKey.length-keySize+1; i++ ) {
    		
    		for(int j = keySize-1 ; j < lockKey.length-keySize+1; j++ ) {
    		
    			if(lockKey[i][j] != 1) {
    				return false;
    			}
    		}
    	}

    	return true;
    	
    }
}