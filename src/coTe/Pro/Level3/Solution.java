package coTe.Pro.Level3;

import java.util.Arrays;

class Solution {
	static long ans = Long.MAX_VALUE;
	
	public static void main(String[] args) {
		
		int n = 6;
		int[] times = {7, 10};
		long ans = solution(n, times);
		
		System.out.println(ans);
	}

	public static long solution(int n, int[] times) {

		Arrays.sort(times);

		binarySearch((long)n, times);

		return ans;
	}

	public static void binarySearch(long n, int[] times) {

		long start = 1;
		long end = (long)times[times.length - 1] * n;

		while (start <= end) {
			long cnt = 0;
			long mid = (start + end) / 2;

			for (int i = 0; i < times.length; i++) {
				cnt +=  mid / times[i] ;
			}

			if (cnt >= n) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

	}

}