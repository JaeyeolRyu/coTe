package coTe.Pro.Level2;

public class ProIronSuit {
    public int solution(int n) {
        int ans = 0;
        
        while (n > 0) {
        	
        	if(n%2 == 0) {
        		n /= 2;
        		continue;
        	}
        	
        	ans++;
        	n /= 2;
        	
        }
        
        return ans;
    }
}