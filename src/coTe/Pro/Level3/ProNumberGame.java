package coTe.Pro.Level3;

import java.util.Arrays;

class ProNumberGame {
    public int solution(int[] A, int[] B) {
            int answer = 0;
            
            Arrays.sort(A);
            Arrays.sort(B);
            
            int idx = 0;
            for(int i = 0 ; i < B.length; i++) {
            	
            	if(A[idx] < B[i]) {
            		
            		answer++;
            		idx++;
            	}
            }

            return answer;
        }
    }