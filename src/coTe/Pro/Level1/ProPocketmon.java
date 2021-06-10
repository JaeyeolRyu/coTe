package coTe.Pro.Level1;

import java.util.Arrays;

class ProPocketmon {
    public int solution(int[] nums) {
        Arrays.sort(nums);
    	int answer = 1;
        int idx = 0;
        int pocketmon = nums[0];
        int canNum = nums.length/2 - 1 ;
        while(canNum != 0 && idx != nums.length) {
        	if(nums[idx] != pocketmon) {
        		answer++;
        		canNum--;
        		pocketmon = nums[idx];
        	}
        	idx++;
        }
        return answer;
    }
}