
public class EuclidIteration {
	public int count = 0;
//	public static int count = 0;
//	public static void main(String[] args) 
//	{
//		// TODO Auto-generated method stub
//		System.out.println(gcd(6765,10946));
//		System.out.println(count);
//
//	}
	public /*static*/ int gcd(int m, int n)
	{
		count = 0;
		int temp1 = m;
		int temp2 = n;
		
		while(temp2 != 0)
		{
			count++;
			int switcharoo = temp2;
			temp2 = temp1%temp2;
			temp1 = switcharoo;			
		}
		return temp1;
	}

}
