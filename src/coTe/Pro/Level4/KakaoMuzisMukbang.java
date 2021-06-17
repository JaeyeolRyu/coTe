package coTe.Pro.Level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class KakaoMuzisMukbang {

	public static void main(String[] args) {

		int[] food_times = { 2,2,2,2,2};
		long k = 9;

		int ans = solution(food_times, k);
		System.out.println();
		System.out.println(ans);
	}

	public static int solution(int[] food_times, long k) {
		int answer = -1;
		long sumTime = 0;
		PriorityQueue<Food> pq = new PriorityQueue<>();

		for (int i = 0; i < food_times.length; i++) {
			pq.add(new Food(i + 1, food_times[i]));
			sumTime += food_times[i];
		}

		int times = 0;
		
		if(sumTime <= k ) {
			return answer;
		}

		while (!pq.isEmpty()) {

			Food food = pq.peek();
			int foodCnt = pq.size();

			if (times == food.remain) {
				pq.poll();
				continue;
			}

			if (foodCnt < k) {

				int remain = food.remain;

				while (remain != times && foodCnt < k) {
					k -= pq.size();
					times++;

				}
				
				if(remain == times) {
					pq.poll();
				}
				

			} else { // foodCnt >= k 인경우

				List<Food> foodList = new ArrayList<>();

				while (!pq.isEmpty()) {
					foodList.add(pq.poll());
				}

				Collections.sort(foodList, new Comparator<Food>() {

					@Override
					public int compare(Food o1, Food o2) {
						return o1.idx - o2.idx;
					}
				});

				answer = foodList.get((int) k % foodList.size()).idx;

			}

		}

		return answer;
	}

	static class Food implements Comparable<Food> {

		int idx;
		int remain;

		public Food(int idx, int remain) {

			this.idx = idx;
			this.remain = remain;

		}

		@Override
		public int compareTo(Food other) {

			return this.remain - other.remain;
		}

	}
}