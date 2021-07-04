package coTe.ETC;
public class T2 {
	
	static boolean[] visit = new boolean[8];
	static int cnt = 0;
	
	public static void main(String[] args) {
		
		String num1 = "gfadafg";
		String num2 = "hfhbcg";
		String num3 = "gegaaac";
		
		int ans = solution(num1, num2, num3);
		System.out.println(ans);
		
	}
	
	public static int solution(String num1, String num2, String num3) {
		int answer = -1;
		
		int[] numArr = new int[8];
		
		permutation(0, 8, numArr, num1, num2, num3);
		
		if(cnt != 0) {
			answer = cnt;
		}
		return answer;
	}
	
	
	public static void permutation(int depth, int idx, int[] numArr,String num1, String num2,String num3) {
		
	    if(idx == depth) {

			StringBuilder sb = new StringBuilder();
			
			for(char c : num1.toCharArray()) {
				sb.append(numArr[c-'a']);
			}
			int tempNum1 = Integer.valueOf(sb.toString(), 8);
			
			sb = new StringBuilder();
			
			for(char c : num2.toCharArray()) {
				sb.append(numArr[c-'a']);
			}
			
			int tempNum2 = Integer.valueOf(sb.toString(), 8);
			
			sb = new StringBuilder();
			
			for(char c : num3.toCharArray()) {
				sb.append(numArr[c-'a']);
			}
			
			int tempNum3 = Integer.valueOf(sb.toString(), 8);
	    	
			if(tempNum1 + tempNum2 == tempNum3) {
				cnt++;
			}
			
	    	return;
        }

        for (int i = 0; i < idx; i++) {
            if(!visit[i]) {
                visit[i] = true;
                numArr[depth] = i;
                permutation(depth+1, idx, numArr, num1, num2, num3);
                visit[i] = false;
            }
        }
		
	}
	
}
