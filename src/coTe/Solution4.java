package coTe;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution4 {

    public String solution(int n, int k, String[] cmd) {
       
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
        	
        	String[] tempArr = str.split(" ");
        	
        	switch (tempArr[0]) {
			case "U":
				idx -= Integer.parseInt(tempArr[1]);
				break;

			case "D":
				idx += Integer.parseInt(tempArr[1]);
				break;
			case "C":
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