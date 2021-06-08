package coTe.Pro.Kakao;

import java.util.Arrays;
import java.util.Comparator;

class KakaoInsertAdFail {

	static long[] totalTime;

	public static void main(String[] args) {

		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { "01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29" };

		String ans = solution(play_time, adv_time, logs);
		System.out.println(ans);

	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";

		totalTime = new long[logs.length];
		int[][] timeArr = new int[logs.length][2];

		for (int i = 0; i < logs.length; i++) {

			String[] log = logs[i].split(":|-");

			int startTime = Integer.parseInt(log[0]) * 3600 + Integer.parseInt(log[1]) * 60 + Integer.parseInt(log[2]);
			int endTime = Integer.parseInt(log[3]) * 3600 + Integer.parseInt(log[4]) * 60 + Integer.parseInt(log[5]);
			timeArr[i][0] = startTime;
			timeArr[i][1] = endTime;

		}
		String[] tempAd = adv_time.split(":");
		int adTime = Integer.parseInt(tempAd[0]) * 3600 + Integer.parseInt(tempAd[1]) * 60
				+ Integer.parseInt(tempAd[2]);

		String[] tempPlay = play_time.split(":");
		int playTime = Integer.parseInt(tempPlay[0]) * 3600 + Integer.parseInt(tempPlay[1]) * 60
				+ Integer.parseInt(tempPlay[2]);

		Arrays.sort(timeArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {

					return o1[0] - o2[0];
				}
			}
		});

		if (timeArr[0][0] + adTime > playTime) {

			int tempTime = playTime - adTime;

			return String.format("%02d", tempTime / 3600) + ":" + String.format("%02d", (tempTime % 3600) / 60) + ":"
					+ String.format("%02d", tempTime % 60);

		}

		searchTime(timeArr, adTime);

		int idx = 0;
		long time = 0;
		for (int i = 0; i < totalTime.length; i++) {

			if (totalTime[i] > time) {

				idx = i;
				time = totalTime[i];

			}

		}

		
		answer = String.format("%02d", timeArr[idx][0] / 3600) + ":" + String.format("%02d", (timeArr[idx][0] % 3600) / 60) + ":"
				+ String.format("%02d", timeArr[idx][0] % 60);;

		return answer;
	}

	public static void searchTime(int[][] timeArr, int adTime) {

		for (int i = 0; i < timeArr.length; i++) {
			long timeCnt = 0;
			int startTime = timeArr[i][0];
			int plusAdTime = startTime + adTime;

			for (int j = 0; j <= i; j++) {

				if (startTime < timeArr[j][1]) {

					timeCnt += Math.min(timeArr[j][1], plusAdTime) - startTime;

				}

			}

			for (int k = i + 1; k < timeArr.length; k++) {

				if (plusAdTime > timeArr[k][0]) {

					timeCnt += plusAdTime - timeArr[k][0];

				} else {
					break;
				}

			}

			totalTime[i] = timeCnt;
		}

	}

}