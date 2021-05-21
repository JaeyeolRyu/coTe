package coTe.Pro;

import java.util.ArrayList;
import java.util.List;

class KakaoSusik {

	static long answer = 0;
	static boolean visit[];

	public static void main(String[] args) {

		String expression = "100-200*300-500+20";
		System.out.println(expression);
		long answer = solution(expression);

		System.out.println(answer);

	}

	public static long solution(String expression) {

		List<Long> numSet = new ArrayList<>();
		List<String> operSet = new ArrayList<>();
		List<String> operCnt = new ArrayList<>();

		String[] num = expression.split("\\+|\\-|\\*");

		for (String str : num) {
			numSet.add(Long.parseLong(str));
		}
		for (int i = 0; i < expression.length(); i++) {

			if (expression.charAt(i) == '-') {
				operSet.add("-");
			} else if (expression.charAt(i) == '+') {
				operSet.add("+");
			} else if (expression.charAt(i) == '*') {
				operSet.add("*");
			}
		}

		if (operSet.contains("+")) {
			operCnt.add("+");
		}
		if (operSet.contains("-")) {
			operCnt.add("-");
		}
		if (operSet.contains("*")) {
			operCnt.add("*");
		}

		visit = new boolean[operCnt.size()];

		combOper(numSet, operSet, operCnt, new String[operCnt.size()], 0, operCnt.size());

		return answer;
	}

	public static void combOper(List<Long> numSet, List<String> operSet, List<String> operCnt, String[] oper, int depth,
			int operSize) {

		if (operSize == depth) {
			System.out.println();
			List<Long> cpNumSet = new ArrayList<>(numSet);
			List<String> cpOperSet = new ArrayList<>(operSet);
			calc(cpNumSet, cpOperSet, oper);
			return;
		}

		for (int i = 0; i < operSize; i++) {
			if (!visit[i]) {

				visit[i] = true;
				oper[depth] = operCnt.get(i);
				System.out.println(oper[depth]);
				combOper(numSet, operSet, operCnt, oper, depth + 1, operSize);
				visit[i] = false;
			}

		}

	}

	public static void calc(List<Long> numSet, List<String> operSet, String[] oper) {
		long temp = 0;

		for (int i = 0; i < oper.length; i++) {

			for (int j = 0; j < operSet.size(); j++) {

				if (operSet.get(j).equals(oper[i])) {

					switch (operSet.get(j)) {
					case "+":
						temp = numSet.get(j) + numSet.get(j + 1);

						numSet.remove(j);
						numSet.remove(j);
						operSet.remove(j);
						numSet.add(j, temp);
						j--;

						break;
					case "-":

						temp = numSet.get(j) - numSet.get(j + 1);
						numSet.remove(j);
						numSet.remove(j);
						operSet.remove(j);
						numSet.add(j, temp);
						j--;

						break;
					case "*":

						temp = numSet.get(j) * numSet.get(j + 1);
						numSet.remove(j);
						numSet.remove(j);
						operSet.remove(j);
						numSet.add(j, temp);
						j--;

						break;

					}

				}

			}

		}
		answer = Math.max(answer, Math.abs(numSet.get(0)));

	}

}