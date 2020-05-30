package example1;
public class tax
{
	static void validage(int age)
	{
		if(age<18)
		{
			throw new ArithmeticException("not valid to give vote");
		}
		else
		{
			System.out.println("welcome to vote");
		}
	}
	public static void main(String args[])
	{
		try
		{
			validage(Integer.parseInt(args[0]));
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		System.out.println("Testing Complete");
	}
}
