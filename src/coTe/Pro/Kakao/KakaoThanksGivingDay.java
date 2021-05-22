package coTe.Pro.Kakao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class KakaoThanksGivingDay {
	static DecimalFormat form = new DecimalFormat("#.###");
	public static void main(String[] args) {
		
		String[] lines = {"2016-09-15 01:00:04.004 2.004s", "2016-09-15 01:00:04.004 2.005s","2016-09-15 01:00:04.002 2.002s", "2016-09-15 01:00:04.001 2.001s", "2016-09-15 01:00:04.006 2.006s", "2016-09-15 01:00:04.005 2.005s"};
		int ans = solution(lines);
		System.out.println(ans);
		
	}
    public static int solution(String[] lines) {
    	
    	if(lines.length == 1) {
    		return 1;
    	}
        int answer = 0;
        double[][] timeArr = new double[lines.length][2];
        int i = 0;
        for(String str : lines) {
        	String[] tempArr = str.split(" "); 
        	String[] time = tempArr[1].split(":");
        	String procTime = tempArr[2].replace("s", "");

        	double endTime = Integer.parseInt(time[0])*3600 + Integer.parseInt(time[1])*60 + Double.parseDouble(time[2]);  
        	
        	double startTime = Double.parseDouble(form.format(endTime-Double.parseDouble(procTime)+0.001));
        	timeArr[i][0] = startTime;
        	timeArr[i][1] = endTime;
        	
        	i++;
        }
    	Arrays.sort(timeArr, (o1, o2)-> {
    		if(o1[0] == o2[0]) {
    			return Double.compare(o1[1], o2[1]);
    		} else {
    			return Double.compare(o1[0], o2[0]);
    		}
    	
    	});
    	
    	System.out.println(Arrays.toString(timeArr[0]));
    	System.out.println(Arrays.toString(timeArr[1]));
    	System.out.println(Arrays.toString(timeArr[2]));
    	System.out.println(Arrays.toString(timeArr[3]));
    	System.out.println(Arrays.toString(timeArr[4]));
    	
        answer = throughtput(timeArr);
        
        return answer;
    }
    
    public static int throughtput(double[][] timeArr) {
    	int max = 0;
    	int cnt = 0;
    	List<Double> endTimeList = new ArrayList<>();
    	for(int i = 0 ; i < timeArr.length; i++) {
    		
    		double startTime = timeArr[i][0];
    		
    		if(endTimeList.isEmpty()) { //비어있으면 들어오는시간의 endtime값 넣는다
    			endTimeList.add(timeArr[i][1]);
    			Collections.sort(endTimeList);
    			cnt++;
    		} else { 
    			int tempNum = endTimeList.size();
    			
    			
    			if(startTime >= endTimeList.get(0)) {
    				for(int j = 0; j < tempNum; j++) {
	    				if(Double.parseDouble(form.format(endTimeList.get(0)+0.999)) < startTime) {
	    					endTimeList.remove(0);
	    					cnt--;
	    	    			
	    				} else {
	    					endTimeList.add(timeArr[i][1]);
	    	    			Collections.sort(endTimeList);
	    	    			cnt++;
	    	    			break;
	    				}
    				}
    			}else {
    				
    				for(int j = 0; j < tempNum; j++) {
        				if(Double.parseDouble(form.format(startTime+0.999)) <= endTimeList.get(0)) {
        	    			endTimeList.add(timeArr[i][1]);
        	    			Collections.sort(endTimeList);
        	    			cnt++;
        	    			break;
        				} else {
        					endTimeList.remove(0);
        					cnt--;
        				}
        				
        			}
    				
    			}
    			
    		}
    		
    		max = Math.max(max, cnt);
    	}
    	
    	return max;
    }
    
}