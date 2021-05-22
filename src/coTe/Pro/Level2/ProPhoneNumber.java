package coTe.Pro.Level2;

import java.util.Arrays;

class ProPhoneNumber {

//	public static void main(String[] args) {
//
//		String[] phone_book = {"325","123","1235", "124" ,"13","121","567", "88"};
//
//		boolean answer = solution(phone_book);
//
//		System.out.println(answer);
//
//	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length-1; i++) {

			if(phone_book[i+1].startsWith(phone_book[i])) {
						return false;
			}

		}
		return answer;
	}
}