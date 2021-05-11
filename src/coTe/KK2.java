package coTe;

import java.util.Arrays;

class KK2 {

	public static void main(String[] args) {
		
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};  
		
		int[] ans = solution(places);
		
		System.out.println(Arrays.toString(ans));
	}
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        int idx = 0;
        for(String[] str : places) {
        	
        	answer[idx] = checkSeat(str);
        	idx++;
        }
 
        return answer;
    }
    
    public static int checkSeat(String[] roomArr) {
    	char[][] seatArr = new char[5][5];
    	int[][]	tempPoint = new int[25][2];
    	int x=0;

    	for(int i = 0 ; i < 5; i++) {
    		
    		for(int j = 0; j < 5; j++) {
    			
    			seatArr[i][j] = roomArr[i].charAt(j);
    			if( seatArr[i][j] == 'P') {
    				tempPoint[x][0] = i;
    				tempPoint[x][1] = j;
    				x++;
    			}
    		}
    		
    	}
    	int[][] pPoint = new int[x][2];
    	
    	for(int i = 0 ; i < x; i++) {
    		
    		pPoint[i][0] = tempPoint[i][0];
    		pPoint[i][1] = tempPoint[i][1];
    	}
    		
    	for(int i = 0 ; i < pPoint.length; i++) {
    		
    		for(int j = i+1; j < pPoint.length; j++) {

    			int dis = Math.abs(pPoint[i][0]-pPoint[j][0]) + Math.abs(pPoint[i][1]-pPoint[j][1]);
    			if(dis == 1) {
    				return 0;
    			} else if(dis == 2) {
    				
    				if(pPoint[i][0] == pPoint[j][0]) {
    					int temp = Math.min(pPoint[i][1], pPoint[j][1]);
    					
    					if(seatArr[pPoint[i][0]][temp+1] == 'O') {
    						return 0;
    					}
    					
    				} else if(pPoint[i][1] == pPoint[j][1]) {
    					int temp = Math.min(pPoint[i][0], pPoint[j][0]);
    					
    					if(seatArr[temp+1][pPoint[i][1]] == 'O') {
    						return 0;
    					}
    					
    				} else if(seatArr[pPoint[i][0]][pPoint[j][1]] == 'O' || seatArr[pPoint[j][0]][pPoint[i][1]] == 'O')  {
    					return 0;
    				}
    			
    			}
    			
    		}
    		
    	}
    	
    	return 1;
    	
    }
 
}