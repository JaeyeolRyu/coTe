package coTe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minQ = new PriorityQueue<>((o1, o2) -> o1 -o2);
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 -o1);
		
		int N = Integer.parseInt(br.readLine());
		
		maxQ.offer(Integer.parseInt(br.readLine()));
		sb.append(maxQ.peek()).append('\n');
		for(int i = 2; i < N+1 ; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(i%2 == 0 ) { //짝수일경우

					minQ.offer(num);
				
			} else { //홀수일경우
				
					maxQ.offer(num);
				
			}
			
			if(maxQ.peek() > minQ.peek() ) {
				
				int temp = maxQ.poll();
				maxQ.offer(minQ.poll());
				minQ.offer(temp);
			}

			sb.append(maxQ.peek()).append('\n');
			
		}
	
		System.out.println(sb);
	}
	
}
