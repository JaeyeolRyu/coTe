package coTe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
	
	public static void main(String[] args) {
		
		int n = 8; 
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		
		String ans = solution(n, k, cmd);
		System.out.println(ans);
		
	}
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        List<Integer> friendsList = new ArrayList<Integer>();
        Stack<Integer> idxStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        int[] cArr = new int[cmd.length];
        for(int i = 0 ; i < n; i++) {
        	
        	friendsList.add(i);
        	
        }
        int cPoint = 0;
       
        for(int i = 0; i < cmd.length; i++) {
        	System.out.println(i+"번쨰");
        	if(cmd[i].charAt(0) == 'C') {
        		cArr[cPoint] = i;
        		cPoint++;
        	} else if(cmd[i].charAt(0) == 'Z') {
        		cPoint--;
        		cArr[cPoint] = 0;
        	}
        }
        System.out.println(Arrays.toString(cArr));
        int idx = k;
        cPoint = 0;
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
				--n;
				if(cArr[cPoint] != i ) {
					if(idx == n) {
						idx--;
					}
					break;
				}
				
					System.out.println("C : "+ idx + " " + friendsList.get(idx));
					idxStack.add(idx);
					valueStack.add(friendsList.get(idx));
					friendsList.remove(idx);
					
					if(idx == friendsList.size()) {
						idx--;
					}
					cPoint++;
				break;
				
			case "Z":			


				break;

        	}
        	
        	i++;
        }
        
        for(int num = 0; num < n; num++) {
        	
        	if(friendsList.contains(num)) {
        		
        		answer += "O";
        		
        	} else {
        		answer += "X";
        	}
	
        }
        
        return answer;
    }
}