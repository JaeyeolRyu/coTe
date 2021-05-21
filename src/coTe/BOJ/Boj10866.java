package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj10866 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		Deque<Integer> d = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i < N ; i++)  {
			
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push_front":
				
				d.offerFirst(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_back":
				
				d.offerLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				
				if(d.size() == 0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(d.pollFirst()).append('\n');
				}
				break;
				
			case "pop_back":
				
				if(d.size() == 0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(d.pollLast()).append('\n');
				}
				
				break;
				
			case "size":
				
				sb.append(d.size()).append('\n');
				break;

			case "empty":
			
				if(d.size() == 0) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
				
			case "front":
				
				if(d.size() == 0) {
					sb.append(-1).append('\n');
				} else {
					sb.append(d.peekFirst()).append('\n');
				}
				break;
				
			case "back":
				
				if(d.size() == 0) {
					sb.append(-1).append('\n');
				} else {
					sb.append(d.peekLast()).append('\n');
				}
				break;

			}
			
			
		}
		
		System.out.println(sb);
	}

}
