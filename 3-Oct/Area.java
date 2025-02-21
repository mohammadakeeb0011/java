/**
*	Program for calculating area of circle
*
*/
import java.util.Scanner;
class Area{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		final double PI = 3.1416;
		double r,a;
		System.out.print("Enter the radius of the circle: ");
		r = scan.nextDouble();
		System.out.println("Enter the area of the circle = " + (PI*r*r));
	}
}