import java.util.Scanner;
class Demo{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = scan.nextLine();
		System.out.print("Your name is :" + name);
	}	
}