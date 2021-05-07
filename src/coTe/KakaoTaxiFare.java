package coTe;

class KakaoTaxiFare {
    int[][] routeCost;
    
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int INF = n*100000;
        
        routeCost = new int[n+1][n+1];
        
        for(int i = 1; i < n+1; i++) {
        	for(int j = 1; j < n+1; j++) {
        		routeCost[i][j] = INF;
        	}
        	routeCost[i][i] = 0;
        }

        for(int[] temp : fares) {
        	routeCost[temp[0]][temp[1]] = temp[2];
        	routeCost[temp[1]][temp[0]] = temp[2];
        }
        
        answer = calTaxiFare(n,s,a,b);
        
        return answer;
    }
    
	public int calTaxiFare(int totalP, int startP, int homeA, int homeB) {
    
		int min = totalP*100000;
		
		for(int k = 1; k <= totalP; k++) { //경유지점
			
			for(int i = 1; i <= totalP; i++) { // 출발지점
				
				for(int j = 1; j <= totalP; j++) { // 도착지점
					
					if(routeCost[i][j] > routeCost[i][k] + routeCost[k][j]) {
						routeCost[i][j] = routeCost[i][k] + routeCost[k][j];
					}			
					
				}
				
			}
			
		}
		
		for(int i = 1; i <= totalP; i++) {
			
			min = Math.min(min, routeCost[startP][i] + routeCost[i][homeA] + routeCost[i][homeB]);
			
		}
		
    	return min;
    	
    }

}