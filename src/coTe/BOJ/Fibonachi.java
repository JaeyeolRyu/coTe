package coTe.BOJ;

public class Fibonachi {

	 public static void main(String[] args) {
	        System.out.println(Fibonachi.fiboSequence(50));
	    }

	    public static String fiboSequence(int n){
	        StringBuffer sb = new StringBuffer();
	        for(int i=1; i<=n; i++){
	            if(i!=1) sb.append(", ");
	            sb.append(fibonachi(i));
	        }

	        return sb.toString();
	    }


	    public static int fibonachi(int n){
	        int result=0;
	        if(n>2) {
	            result = fibonachi(n-2)+fibonachi(n-1);
	        }

	        if(n<=2) result = n-1;

	        return result;
	    }


	
	
}
