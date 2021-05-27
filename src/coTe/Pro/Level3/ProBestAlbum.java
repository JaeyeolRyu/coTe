package coTe.Pro.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProBestAlbum {

	public static void main(String[] args) {

		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] ans = solution(genres, plays);

		System.out.println(Arrays.toString(ans));

	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		Map<String, Integer> genresMap = new HashMap<String, Integer>();
		Map<String, HashMap<Integer, Integer>> cntMap = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {

			int play = genresMap.getOrDefault(genres[i], 0);

			if (play == 0) {
				cntMap.put(genres[i], new HashMap<>());
			}

			genresMap.put(genres[i], play + plays[i]);
			cntMap.get(genres[i]).put(i, plays[i]);

		}

		List<Integer> answerList = new ArrayList<>();

		List<String> keySet = new ArrayList<>(genresMap.keySet());

		Collections.sort(keySet, (o1, o2) -> (genresMap.get(o2).compareTo(genresMap.get(o1))));

		for (String key : keySet) {

			List<Integer> list = new ArrayList<>(cntMap.get(key).keySet());

			Collections.sort(list, (o1, o2) -> (cntMap.get(key).get(o2).compareTo(cntMap.get(key).get(o1))));

			if (list.size() < 2) {

				answerList.add(list.get(0));

			} else {

				for (int i = 0; i < 2; i++) {

					answerList.add(list.get(i));

				}

			}

		}

		answer = new int[answerList.size()];

		for (int i = 0; i < answerList.size(); i++) {

			answer[i] = answerList.get(i);

		}

		return answer;
	}
}