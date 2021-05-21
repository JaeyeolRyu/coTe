package coTe.Pro;

import java.util.Arrays;
import java.util.Comparator;

class KakaoFailRate {
	
//	public static void main(String[] args) throws Exception {
//
//		int N = 5;
//		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3};
//		int[] answer = new int[N];
//		answer = solution(N, stages);
//
//		for(int i = 0 ; i < N; i++) {
//
//			System.out.print(answer[i]);
//	
//		}
//	}
	
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] arr = new int[N+2];

        double[][] failRate = new double[N][2]; 
        
        for(int i = 0; i < N; i++) {
        	failRate[i][0] = i+1;
        }
        
        for(int stage : stages) {
        	if(stage != N+1)
        		arr[stage-1]++;
        }
        
        int temp = stages.length;
        
        for(int i = 0 ; i < N; i++) {
        	
        	failRate[i][1] = (double)arr[i]/temp;
        	temp -= arr[i];
        	
        	if(temp == 0) {
        		break;
        	}
        }
        
       Arrays.sort(failRate,new Comparator<double[]>() {

		@Override
		public int compare(double[] o1, double[] o2) {
			if(o1[1]<o2[1]) {
                return 1;
            }
            else if(o1[1]==o2[1]) {
                return (int) (o1[0]-o2[0]);
            }else {
                return -1;
            }
		}
       });
       
       for(int i = 0 ; i < N; i++) {
    	   answer[i] = (int)failRate[i][0]; 
       }
       
       
       return answer;
    }
}
