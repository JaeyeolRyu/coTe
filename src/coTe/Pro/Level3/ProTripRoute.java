package coTe.Pro.Level3;

import java.util.*;

class ProTripRoute {

	static List<String> possible = new ArrayList<String>();
	static boolean[] visit;

	public static void main(String[] args) {

		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

		String[] ans = solution(tickets);

		System.out.println(Arrays.toString(ans));

	}

	public static String[] solution(String[][] tickets) {
		String[] answer = new String[tickets.length + 1];

		visit = new boolean[tickets.length];

		checkRoute(tickets, 0, "ICN ", "ICN");
		Collections.sort(possible);
		answer = possible.get(0).split(" ");

		return answer;
	}

	public static void checkRoute(String[][] tickets, int depth, String route, String destination) {

		if (depth == tickets.length) {
			possible.add(route.toString());
			return;
		}

		for (int i = 0; i < tickets.length; i++) {

			if (!visit[i] && destination.equals(tickets[i][0])) {

				visit[i] = true;
				String dst = tickets[i][1];
				checkRoute(tickets, depth + 1, route + dst + " ", dst);
				visit[i] = false;

			}

		}

	}

}