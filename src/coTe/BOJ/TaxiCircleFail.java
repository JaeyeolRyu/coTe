package coTe.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxiCircleFail {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat format = new DecimalFormat();
		format.applyLocalizedPattern("0.000000");
		
		int R = Integer.parseInt(br.readLine());
		double pi = 3.14159265359;
		
		double round =  Math.round(R*pi*1000000)/1000000.0;
		double taxi = (R+R);
		
		System.out.println(round);
		System.out.println(format.format(taxi));

	}

}
