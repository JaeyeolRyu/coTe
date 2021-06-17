package coTe.Pro.Level4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class KakaoSearchLyrics {

	static Node root = new Node();
	static Node reverseRoot = new Node();
	
	public static void main(String[] args	 ) {
		
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"???????", "????o", "fr???", "fro???", "pro?"};
		
		int[] ans = solution(words, queries);
		
		System.out.println(Arrays.toString(ans));
		
	}
	public static int[] solution(String[] words, String[] queries) {

		int[] answer = new int[queries.length];

		for (String word : words) {
			insert(word);
			reverseInsert(word);
		}

		for (int i = 0; i < queries.length; i++) {

			if (queries[i].charAt(0) == '?') {
				answer[i] = reverseFind(queries[i]);
			} else {
				answer[i] = find(queries[i]);
			}
			
		}

		return answer;
	}

	public static int charToint(char c) {
		return c - 'a';
	}

	public static void insert(String str) {

		int len = str.length();
		Node current = root;
		for (int i = 0; i < len; i++) {

			char c = str.charAt(i);
			int idx = charToint(c);

			if (current.child[idx] == null) {

				current.child[idx] = new Node();
				current.child[idx].val = c;
				
			}
		
			current.len.put(len, current.len.getOrDefault(len, 0)+1);
			System.out.println(c + "  " + len + "  " + current.len.get(len));
			current = current.child[idx];
			

		}

		current.isLast = true;
	}

	public static void reverseInsert(String str) {

		int len = str.length();
		Node current = reverseRoot;
		for (int i = len - 1; i >= 0; i--) {

			char c = str.charAt(i);
			int idx = charToint(c);

			if (current.child[idx] == null) {

				current.child[idx] = new Node();
				current.child[idx].val = c;
				
			}
			
			current.len.put(len, current.len.getOrDefault(len, 0)+1);
			System.out.println(c + "  " + len + "  " + current.len.get(len));
			current = current.child[idx];
			
		}

		current.isLast = true;
	}

	public static int find(String str) {

		int idx = 0;
		int len = str.length();
		String word = str.replace("?", "");
	
		Node current = root;

		for (int i = 0; i < word.length(); i++) {

			idx = word.charAt(i) - 'a';
			if (current.child[idx] != null) {
				current = current.child[idx];
			} else {
				return 0;
			}

		}

		return current.len.getOrDefault(len, 0);

	}

	public static int reverseFind(String str) {

		int idx = 0;
		int len = str.length();
		String word = str.replace("?", "");
		
		Node current = reverseRoot;

		for (int i = word.length() - 1; i >= 0; i--) {

			idx = word.charAt(i) - 'a';
			if (current.child[idx] != null) {
				current = current.child[idx];
			} else {
				return 0;
			}

		}

		return current.len.getOrDefault(len, 0);

	}

	static class Node {

		Node[] child = new Node[26];
		boolean isLast = false;
		char val;
		Map<Integer, Integer> len = new HashMap<Integer, Integer>();

	}

}