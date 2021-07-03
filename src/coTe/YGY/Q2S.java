package coTe.YGY;

import java.util.LinkedList;
import java.util.Queue;

public class Q2S {
	
	private Queue<Object> mainQ = new LinkedList<>();
	private Queue<Object> subQ	= new LinkedList<>();

	public static void main(String[] args) throws Exception {
		
		Q2S stack = new Q2S();
		
		stack.push(1);
		stack.push("aas123");
		stack.push('T');
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		
	}
	
	public void push(Object item) {
		mainQ.add(item);
	}
	
	public Object pop() {
		
		if(!mainQ.isEmpty()) {
			Object result = null;
			while(true) {
				result = mainQ.poll();
				if(mainQ.isEmpty()) {
					break;
				}else {
					subQ.add(result);
				}

			}
			
			
			while(!subQ.isEmpty()) {
				mainQ.add(subQ.poll());
			}
		
			return result;
		} else {
			return null;
		}
		
		
	}
	
	
}
