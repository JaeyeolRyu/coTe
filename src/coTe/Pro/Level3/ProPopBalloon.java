package coTe.Pro.Level3;

class ProPopBalloon {
	public int solution(int[] a) {
		int answer = 0;

		int[] leftMin = new int[a.length];
		int[] rightMin = new int[a.length];

		int left = 1000000001;
		int right = 1000000001;

		for (int i = 0; i < a.length; i++) {

			if (a[i] < left) {
				left = a[i];
			}
			leftMin[i] = left;

			if (a[a.length - 1 - i] < right) {
				right = a[a.length - 1 - i];
			}
			rightMin[a.length - 1 - i] = right;

		}
		
		for(int i = 0 ; i < a.length; i++) {
			
			if(a[i] > leftMin[i] && a[i] > rightMin[i] ) {
				continue;
			}
			answer++;
		}

		return answer;
	}
}