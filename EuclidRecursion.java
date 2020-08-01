
public class EuclidRecursion 
{
	public /*static*/ int count = 0;
/*	public static void main(String[] args) 
	{
		System.out.println("The gcd of 56 & 91 is: " + gcd(56,91));
		System.out.println("the gcd was found in: " + callCount + " loops");
		callCount = 0;
		System.out.println();
		//System.out.println("the first gcd was found in : " + count + " loops");
		System.out.println("The gcd of 8088 & 6502 is: " + gcd(8088,6502));
		System.out.println("the gcd was found in: " + callCount + " loops");
		callCount = 0;
		System.out.println();
		System.out.println("The gcd of 801 & 495 is: " + gcd(801,495));
		System.out.println("the gcd was found in: " + callCount + " loops");
		callCount = 0;		
		System.out.println();
		System.out.println("The gcd of 6765 & 10946 is: " + gcd(6765,10946));
		System.out.println("the gcd was found in: " + callCount + " loops");
		callCount = 0;
//		System.out.println();
//		System.out.println();
//		System.out.println();
		//		System.out.println();
	}*/
	public /*static*/ int gcd(int m, int n)
	{
		count++;
		if(n == 0)
		{
			return m;
		}
		return gcd(n, m%n);
	}

}
