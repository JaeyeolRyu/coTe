package coTe.ETC;
public class N3 {
	public int solution(String s, String t) {
		int result = 0;
		int len = t.length();
		StringBuilder sb = new StringBuilder(s);

		while (sb.toString().contains(t)) {
			int startIdx = sb.indexOf(t);
			
			sb.delete(startIdx, startIdx + len);
			result++;
		}

		return result;
	}
}