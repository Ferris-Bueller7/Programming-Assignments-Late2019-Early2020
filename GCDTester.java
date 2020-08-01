import java.time.*;
public class GCDTester {

	public static void main(String[] args) 
	{
		int loop = 100000000;
		EuclidIteration test = new EuclidIteration();
		//System.out.println(test.gcd(12,12));
		EuclidRecursion test2 = new EuclidRecursion();
		//System.out.println(test2.gcd(12,12));
		long itStart =ZonedDateTime. now(). toInstant(). toEpochMilli();
		for(int i = 0; i < loop; i++)
		{
			test.gcd(6765,10946);
			
		}
		long itEnd =ZonedDateTime. now(). toInstant(). toEpochMilli();
		System.out.printf("The speed of iteration is %.3f seconds\n",((double)itEnd-itStart)/1000);
		long recStart =ZonedDateTime. now(). toInstant(). toEpochMilli();
		for(int i = 0; i < loop; i++)
		{
			test2.gcd(6765,10946);
		}
		long recEnd =ZonedDateTime. now(). toInstant(). toEpochMilli();
		System.out.printf("The speed of recursion is %.3f seconds",((double)recEnd-recStart)/1000);
	}

}
