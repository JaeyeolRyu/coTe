package coTe;

public class qqq {

	public static void main(String[] args) {	
		int []ary1 = {11,15,19,21,22,23,24};
		int []ary2 = {5,16,17,21,22,28};
		int i,j, k = 0;
	
		for(i = 0; i < ary1.length; i++)
		{
			for(j = k; j< ary2.length ; j++)
			{
				if(ary1[i]>ary2[j])
				{
				System.out.print(ary2[j]+" ");
				}
				else if(ary1[i] ==ary2[j])
				{
					k = j;
					j = ary2.length;
				}
				else
				{	
					System.out.print(ary1[i] + " ");
					k = j;
					j = ary2.length;
				}
			}
		}
		if(ary1[i-1]<ary2[k])
		{
			System.out.print(ary2[k]);
		}
	
	}
}