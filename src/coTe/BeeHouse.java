package coTe;
import java.util.Scanner;

public class BeeHouse {

    public static void main(String[] args) {
    
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();

    	//  A(n) = A(n-1) + 6*(n-1) 
    	
    	int PrevNum = 1;
    	int count = 1;
    	
    	while ( true ) {
    			
	    	if( PrevNum >= N ) {
	    		
	    		break;
	    	}

	    	PrevNum += 6*count;		
    		
	    	count++;
    	}
    		
    	System.out.println(count);
    }
} 
