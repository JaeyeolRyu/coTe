package coTe.Pro;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class KK4 {
	
	public static void main(String[] args) {
		
		int n = 8; 
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		
		String ans = solution(n, k, cmd);
		System.out.println(ans);
		
	}
    public static String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        List<Integer> friendsList = new ArrayList<Integer>();
        Stack<Integer> idxStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        
        for(int i = 0 ; i < n; i++) {
        	
        	friendsList.add(i);
        	
        }
        
        int idx = k;
        int i = 0;
        for(String str : cmd) {
        	System.out.println(i+"번쨰");
        	String[] tempArr = str.split(" ");
        	
        	switch (tempArr[0]) {
			case "U":
				System.out.println("U전 : " + idx);
				idx -= Integer.parseInt(tempArr[1]);
				System.out.println("U후 : " + idx);
				break;

			case "D":
				System.out.println("D전 : " + idx);
				idx += Integer.parseInt(tempArr[1]);
				System.out.println("D후 : " + idx);
				break;
			case "C":
				System.out.println("C : "+ idx + " " + friendsList.get(idx));
				idxStack.add(idx);
				valueStack.add(friendsList.get(idx));
				friendsList.remove(idx);
				
				if(idx == friendsList.size()) {
					idx--;
				}
				
				break;
			case "Z":				
				if(idxStack.peek()<= idx) {
					idx++;
				}
				
				friendsList.add(idxStack.pop(),valueStack.pop());
				System.out.println("Z : "+ idx + " " + friendsList.get(idx));
				
				break;

        	}
        	i++;
        }
        
        for(int num = 0; num < n; num++) {
        	
        	if(friendsList.contains(num)) {
        		
        		sb.append("O");
        		
        	} else {
        		sb.append("X");
        	}
	
        }
       
        return sb.toString();
    }
}