package coTe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ProDisguise {

	public static void main(String[] args) {

		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		int answer = solution(clothes);

		System.out.println(answer);

	}

	public static int solution(String[][] clothes) {
		int answer = -1;

		Map<String, Integer> clothesMap = new HashMap<>();

		for (String[] str : clothes) {

			int cnt = clothesMap.getOrDefault(str[1], 0);

			clothesMap.put(str[1], cnt + 1);

		}

		int temp = 1;

		Iterator<String> it = clothesMap.keySet().iterator();

		while (it.hasNext()) { 

			temp *= clothesMap.get(it.next()) + 1;

		}

		answer += temp;

		return answer;
	}

}