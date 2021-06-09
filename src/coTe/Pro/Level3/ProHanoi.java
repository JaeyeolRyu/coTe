package coTe.Pro.Level3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ProHanoi {

	List<int[]> seqList = new ArrayList<int[]>();

	public int[][] solution(int n) {
		int[][] answer = {};

		Hanoi(n, 1, 2, 3);
		

		answer = new int[seqList.size()][2];
		Iterator<int[]> it = seqList.iterator();
		int idx = 0;

		while (it.hasNext()) {
			
			answer[idx] = it.next();
			idx++;

		}

		return answer;
	}

	public void Hanoi(int n, int start, int mid, int end) {
		int[] inputArr = new int[2];
		if (n == 1) {
			inputArr[0] = start;
			inputArr[1] = end;
			
			seqList.add(inputArr);
			return;
		}

		Hanoi(n - 1, start, end, mid);

		inputArr[0] = start;
		inputArr[1] = end;
		seqList.add(inputArr);

		Hanoi(n - 1, mid, start, end);

	}
}