package coTe.Pro.Kakao;

import java.util.PriorityQueue;

class KaKaoShuttleBus {
	
	public static void main(String[] args ) {
		
		int n = 10;
		int t = 60;
		int m = 45;
		
		String[] timetable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		
		String ans = solution(n, t, m, timetable);
		
		System.out.println(ans);
		
	}
	public static String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		int totalP = n * m;
		int busTime = 540;

		PriorityQueue<Integer> waitingQ = new PriorityQueue<>();

		for (String str : timetable) {

			int hours = Integer.parseInt(str.substring(0,2));
			int minutes = Integer.parseInt(str.substring(3,5));

			waitingQ.add(hours*60 + minutes);

		}

		int acceptable = 0;

		while (!waitingQ.isEmpty()) {

			if (waitingQ.peek() <= busTime) { // 버스 오기전에 모이는 사람 수

				if (totalP == 1) {
					int tempTime = waitingQ.poll()-1;
					answer = String.format("%02d", tempTime/60) + ":" + String.format("%02d", tempTime%60);
					return answer;

				}

				totalP--;
				acceptable++;
				waitingQ.poll();

				if (acceptable == m) { // 첫버스에 수용인원이 다차면 대기인원다시모아야함.

					busTime += t;
					acceptable = 0;
					n--;

				}

			} else { // 버스시간보다 빨리온 사람이 없을 때

				if (n == 1) {
					answer = String.format("%02d", busTime/60) + ":" + String.format("%02d", busTime%60);
					return answer;
					
				} else {

					totalP = --n*m;
					busTime += t;
					acceptable = 0;
					
				}

			}

		}
		
		answer = String.format("%02d", busTime/60) + ":" + String.format("%02d", busTime%60);
		
		return answer;
	}
}
