package coTe.Pro.Level3;

class ProCollectSticker {
	public int solution(int sticker[]) {
		int len = sticker.length;
		int dp1[] = new int[len]; // 첫번쨰 스티커로 시작
		int dp2[] = new int[len]; // 두번째 스티커로 시작

		if (len == 1) {
			return sticker[0];
		} else if (len == 2) {
			return Math.max(sticker[0], sticker[1]);
		}

		dp1[0] = dp1[1] = sticker[0];
		dp2[1] = sticker[1];

		for (int i = 2; i < len - 1; i++) {
			dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
		}

		dp2[len - 1] = Math.max(dp2[len - 2], dp2[len - 3] + sticker[len - 1]);

		return Math.max(dp1[len - 2], dp2[len - 1]);
	}
}