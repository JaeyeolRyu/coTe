package coTe.Pro;

import java.util.ArrayList;
import java.util.List;

class ProPrimeNumber {

	static List<Integer> answerList = new ArrayList<>();
	static char[] numberArr;
	static boolean[] visit;

	public static void main(String[] args) {
		
		String numbers = "011";
		
		int answer = solution(numbers);
		System.out.println(answer);
	}
	
	public static int solution(String numbers) {
		int answer = 0;

		numberArr = numbers.toCharArray();
		visit = new boolean[numbers.length()];

		for (int i = 1; i <= numberArr.length; i++) {

			combination(new StringBuilder(), 0, i, numberArr.length);

		}

		answer = answerList.size();

		return answer;
	}

	public static void combination(StringBuilder sb, int depth, int idx, int length) {

		if (idx == depth) {
			System.out.println(Integer.parseInt(sb.toString()));
			if (Integer.parseInt(sb.toString()) > 1) {
				calculation(Integer.parseInt(sb.toString()));
			}
			return;
		}

		for (int i = 0; i < length; i++) {

			if (!visit[i]) {

				visit[i] = true;
				sb.append(numberArr[i]);
				combination(sb, depth + 1, idx, length);
				sb.setLength(sb.length() - 1);
				visit[i] = false;
			}

		}

	}

	public static void calculation(int num) {

		if(num == 2) {
			if (!answerList.contains(num)) {
				System.out.println("통과: " +num);
				answerList.add(num);
			}
		}
		
		for (int i = 2; i < num; i++) {
			
			if (num % i == 0) {
				return;
			}
		}

		if (!answerList.contains(num)) {
			System.out.println("통과: " +num);
			answerList.add(num);
		}

	}

}