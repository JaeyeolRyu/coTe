package coTe.ETC;
import java.util.Arrays;

public class T1 {
	
	public static void main(String[] args) {
		
		String logs = "2019/05/01 00:59:19\n2019/05/01 16:59:19\n2019/05/01 15:59:19\n2019/05/01 15:59:19";
		int[] answer = solution(logs);
		
		System.out.println(Arrays.toString(answer));
		
		
	}
	
	
	public static int[] solution(String logs) {
		int[] answer = new int[24];
		
		String[] log = logs.split("\n");
		
		for(int i = 0 ; i < log.length; i++) {
			
			String logTime = log[i].substring(11,13);
			
			int kTime = (Integer.parseInt(logTime) + 9) % 24;
			answer[kTime]++;
		}
		
		
		
		return answer;
	}
}
