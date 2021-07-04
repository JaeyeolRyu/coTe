package coTe.ETC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class N2 {
	
	public static void main(String[] args) {
		
		String s = "aasdfqwegaaaaaaaaaaaaaaaaajdlgkuweqoiqwyghvbsdjkbfakjhaaaaaaaaaadddddddddhkasjfhasdkfjhsadkgjhbkjadhfabdasdfa";
		
		String[] ans = solution(s);
		
		System.out.println(Arrays.toString(ans));
		
		
	}
	
	public static String[] solution(String s) {
		List<String> symList = new ArrayList<String>();
		StringBuilder sbFront = new StringBuilder();
		StringBuilder sbEnd = new StringBuilder();
		int lastIdx = s.length() - 1;
		boolean isEven = false;

		if (s.length() % 2 == 0) {
			isEven = true;
		}

		for (int i = 0; i < s.length() / 2; i++) {

			sbFront.append(s.charAt(i));
			sbEnd.insert(0, s.charAt(lastIdx - i));

			if (sbFront.toString().equals(sbEnd.toString())) {

				symList.add(sbFront.toString());
				sbFront = new StringBuilder();
				sbEnd = new StringBuilder();

			}

		}

		List<String> reverseList = new ArrayList<>(symList);
		Collections.reverse(reverseList);

		if(isEven) {
			
			if(sbFront.length() != 0) {
				String tempStr = sbFront.toString() + sbEnd.toString();
				symList.add(tempStr);
			}
			
		} else {
			
			String remainStr = String.valueOf(s.charAt(s.length() / 2));
			String tempStr = sbFront.toString() + remainStr + sbEnd.toString();
			symList.add(tempStr);
			
		}

		List<String> ansList = new ArrayList<>();
		ansList.addAll(symList);
		ansList.addAll(reverseList);

		String[] answer = ansList.toArray(new String[0]);

		return answer;
	}
}