package coTe.YGY;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2Q {

	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {

		BufferedReader br;
		StringTokenizer st;
		
		try {
			
			while (true) {
				System.out.println("poll은 p를 입력하시고, add는 a를 입력하시고 한칸 띄우신 후 숫자를 입력하여 주십시오.");
	
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine(), " ");
	
				String condi = st.nextToken();
	
				if (!condi.equals("a") && !condi.equals("p")) {
					System.out.println("입력정보가 잘못되었습니다. 다시한번 확인 부탁드립니다.");
				} else {
	
					switch (condi) {
					case "a":
						
						String tempStr = st.nextToken();

						if(tempStr.matches("-?\\d+")) {
							int num = Integer.parseInt(tempStr);
							add(num);
						} else {
							System.out.println("입력값이 올바르지 않습니다. 다시한번 확인 부탁드립니다.");
							continue;
						}
						
	
						break;
	
					case "p":
	
						if (stack1.isEmpty() && stack2.empty()) {
							System.out.println("queue가 비어있습니다. add후 pop을 실행해 주시기 바랍니다.");
							continue;
						} else {
							pop();
						}
					}
	
				}
	
			}
		} catch (NumberFormatException ne) {
			System.out.println("입력값이 숫자가 아닙니다. 확인 후 다시 프로그램을 실행해 주십시오.");
		} catch (Exception e) {
			System.out.println("예상치 못한 에러가 발생하였습니다.");
		}
	}

	public static void add(int num) {

		stack1.add(num);

		System.out.println(num + "이 add 되었습니다.");
	}

	public static void pop() {

		if (stack2.isEmpty()) {

			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}

		int num = stack2.pop();

		System.out.println(num + "이 pop 되었습니다.");
	}
}
