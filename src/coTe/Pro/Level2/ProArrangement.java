package coTe.Pro.Level2;

import java.util.Arrays;

class ProArrangement {
	
	public static void main(String[] args) {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] ans = solution(array, commands);
		
		System.out.println(Arrays.toString(ans));
		
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int ansIdx = 0;

		for (int[] command : commands) {

			int[] tempArr = new int[command[1] - command[0] + 1];
			int idx = 0;
			for (int i = command[0] - 1; i < command[1]; i++) {

				tempArr[idx++] = array[i];

			}

			Arrays.sort(tempArr);

			answer[ansIdx++] = tempArr[command[2]-1];
		
		}
		
		return answer;
	}
}