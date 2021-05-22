package coTe.Pro.Level2;

import java.util.LinkedList;
import java.util.Queue;

class ProTruckBridge {

	public static void main(String[] args) {

		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		int ans = solution(bridge_length, weight, truck_weights);
		System.out.println(ans);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int loadWeight = 0;
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < truck_weights.length; i++) {

			while (true) {

				if (q.isEmpty()) {

					q.add(truck_weights[i]);
					loadWeight += truck_weights[i];
					answer++;
					break;

				} else if (q.size() == bridge_length) {

					loadWeight -= q.poll();

				} else {

					if (truck_weights[i] + loadWeight > weight) {

						q.offer(0);
						answer++;

					} else {

						q.offer(truck_weights[i]);
						answer++;
						loadWeight += truck_weights[i];
						break;
					}

				}

			}

		}

		answer += bridge_length;

		return answer;
	}
}