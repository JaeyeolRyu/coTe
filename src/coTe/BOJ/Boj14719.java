package coTe.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14719 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int answer = 0;

		st = new StringTokenizer(br.readLine(), " ");

		boolean[][] blockArr = new boolean[H + 1][W + 1];
		int maxHeight = 0;
		for (int i = 0; i < W; i++) {

			int height = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, height);

			for (int j = 0; j < height; j++) {

				blockArr[j][i] = true;

			}

		}

		int leftIdx = 0;
		for (int i = 0; i <= maxHeight; i++) {

			boolean left = false;

			for (int j = 0; j < W; j++) {

				if (blockArr[i][j]) {

					if (left) {

						answer += (j - leftIdx - 1);
						leftIdx = j;

					} else {

						left = true;
						leftIdx = j;

					}

				}

			}

		}

		System.out.println(answer);
	}
}
