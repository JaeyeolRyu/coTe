package coTe;

import java.util.Arrays;
import java.util.Comparator;

class ProBiggestNumber {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        
        for(int i = 0 ; i < numbers.length; i++) {
        	strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < strArr.length; i++)	 {
        	
        	sb.append(strArr[i]);
        	
        }
        
        if(sb.toString().charAt(0) == '0') {
        	return "0";
        } else {
        	return sb.toString();
        }

   
    }
}