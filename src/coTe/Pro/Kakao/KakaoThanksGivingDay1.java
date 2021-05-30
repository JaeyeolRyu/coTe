package coTe.Pro.Kakao;

import java.util.Arrays;

public class KakaoThanksGivingDay1 {
	public static void main(String[] args) {
		
		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		int ans = solution(lines);
		System.out.println(ans);
		
	}
    public static int solution(String[] lines) {
    	
    	if(lines.length == 1) {
    		return 1;
    	}
        int answer = 0;
        float[][] timeArr = new float[lines.length][2];
        int i = 0;
        for(String str : lines) {
        	String[] tempArr = str.split(" "); 
        	String[] time = tempArr[1].split(":");
        	String procTime = tempArr[2].replace("s", "");

        	float endTime = Float.parseFloat(time[0])*3600 + Float.parseFloat(time[1])*60 + Float.parseFloat(time[2]);  
        	
        	float startTime = endTime-Float.parseFloat(procTime)+(float)0.001;
        	timeArr[i][0] = startTime;
        	timeArr[i][1] = endTime;
        	
        	i++;
        }
    	Arrays.sort(timeArr, (o1, o2)-> {
    		if(o1[0] == o2[0]) {
    			return Float.compare(o2[1], o1[1]);
    		} else {
    			return Float.compare(o2[0], o1[0]);
    		}
    	
    	});
    	
    	for(int p = 0 ; p < timeArr.length; p++) {
    		
    		System.out.println(Arrays.toString(timeArr[p]));
    		
    	}
        answer = throughtput(timeArr);
        
        return answer;
    }
    
    public static int throughtput(float[][] timeArr) {
    	int max = 0;
    	int cnt = 0;
    	
    	for(int i = 0 ; i < timeArr.length; i++) {
    		
    		float startTime = timeArr[i][0];
    		
    		
    		cnt = 0;
    		for(int j = i; j < timeArr.length; j++) {
    			float endTime  = timeArr[j][1];
    			if( startTime-(float)0.999 <= endTime ) {
    				cnt++;
    			} 
    		}
    		max = Math.max(max, cnt);
    	}
    	
    	return max;
    }
}
