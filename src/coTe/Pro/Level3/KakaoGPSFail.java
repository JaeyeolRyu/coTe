package coTe.Pro.Level3;

import java.util.Arrays;

class KakaoGPSFail {
	
	int INF = 9999999;
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        
        int[][] roadArr = new int[n+1][n+1];
        
        for(int i = 1 ; i < n+1; i++) {
        	Arrays.fill(roadArr[i], INF);
        }
        
        for(int i = 0 ; i < edge_list.length; i++) {
        	
        	roadArr[edge_list[i][0]][edge_list[i][1]] = 1;
        	roadArr[edge_list[i][1]][edge_list[i][0]] = 1;
        	
        }
        
        searchRoad(1, n, roadArr);
        
        return answer;
    }
    
    public void searchRoad(int start, int end, int[][] roadArr) {
   
    	
    	
    	
    }
    
    
    
}