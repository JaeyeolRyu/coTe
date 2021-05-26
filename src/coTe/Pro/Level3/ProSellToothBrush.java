package coTe.Pro.Level3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class ProSellToothBrush {
	Map<String, String> recommenderMap = new HashMap<String, String>();
	Map<String, Integer> profitMap = new LinkedHashMap<>();

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];

		for (int i = 0; i < enroll.length; i++) {

			recommenderMap.put(enroll[i], referral[i]);
			profitMap.put(enroll[i], 0);

		}

		for (int i = 0; i < seller.length; i++) {

			String sellIdx = seller[i];
			int price = amount[i] * 100;

			profitMap.put(sellIdx, profitMap.get(sellIdx) + (int) Math.ceil(price * 0.9));

			if (!recommenderMap.get(sellIdx).equals("-")) {
				distribution(recommenderMap.get(sellIdx), (int) (price * 0.1));
			}
		}

		Iterator<String> keySet = profitMap.keySet().iterator();
		int idx = 0;

		while (keySet.hasNext()) {
			answer[idx] = profitMap.get(keySet.next());
			idx++;
		}

		return answer;
	}

	public void distribution(String sellIdx, int price) {

		if ((int) (price * 0.1) == 0) {

			profitMap.put(sellIdx, profitMap.get(sellIdx) + price);

		} else if (recommenderMap.get(sellIdx).equals("-")) {

			profitMap.put(sellIdx, profitMap.get(sellIdx) + (int) Math.ceil(price * 0.9));

		} else {

			profitMap.put(sellIdx, profitMap.get(sellIdx) + (int) Math.ceil(price * 0.9));

			distribution(recommenderMap.get(sellIdx), (int) (price * 0.1));

		}

	}
}