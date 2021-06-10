package coTe.Pro.Level1;

class ProMakePrimeNumber {
	
	boolean[] visit;
	int cnt = 0;
	public int solution(int[] nums) {
		visit = new boolean[nums.length];
		
		combination(nums, 0, 3, 0, 0);
		
		return cnt;
	}
	
	public void combination(int[]nums, int depth, int size, int idx, int sum) {
		
		if(depth == size) {
		
			if(checkPrimeNumber(sum)) {
				cnt++;
			}
			
			return;
		}
		
		for(int i = idx ; i < nums.length; i++	 ) {
			
			if(!visit[i]) {
				visit[i] = true;
				combination(nums, depth+1, size, i+1, sum+nums[i]);
				visit[i] = false;
			}
		}
		
	}
	
	public boolean checkPrimeNumber(int num) {
		
		for(int i = 2; i < num; i++) {
			
			if(num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
}