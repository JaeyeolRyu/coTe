package coTe.Pro.Level3;

class KakaoInsertAd {
	public String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";

		int playTime = timeToSecond(play_time);
		int adTime = timeToSecond(adv_time);
		int[] timeCnt = new int[playTime+1];
		for (int i = 0; i < logs.length; i++) {

			String[] log = logs[i].split("-");

			int startTime = timeToSecond(log[0]);
			int endTime = timeToSecond(log[1]);

			for (int j = startTime; j < endTime; j++) {

				timeCnt[j]++;

			}

		}

		long viewCnt = 0;
		int startTime = 0;
		long max = 0;
		int idx = 0;

		for (int i = 0; i < adTime; i++) {

			viewCnt += timeCnt[i];

		}

		max = viewCnt;

		while (adTime <= playTime) {

			viewCnt += timeCnt[adTime] - timeCnt[startTime];

			if (max < viewCnt) {

				max = viewCnt;
				idx = startTime+1;

			}

			startTime++;
			adTime++;

		}
		
		
		answer = String.format("%02d", idx / 3600) + ":" + String.format("%02d", (idx % 3600) / 60) + ":"
				+ String.format("%02d", idx % 60);

		return answer;
	}

	public int timeToSecond(String str) {

		String[] time = str.split(":");

		return Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
	}

}