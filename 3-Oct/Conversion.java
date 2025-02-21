// Demonstrate casts.
class Conversion {
	public static void main(String args[]) {
		byte b;
		int i = 257;
		double d = 323.142;
		System.out.println("\nConversion of int to byte.");
		b = (byte) i;
		System.out.println("Integer value  =  " + i + "\nByte value = " + b);
		System.out.println("------------------------------------------------");
		System.out.println("\nConversion of double to int.");
		i = (int) d;
		System.out.println("double value  =  " + d + "\nInteger value = " + i);
		System.out.println("------------------------------------------------");
		System.out.println("\nConversion of double to byte.");
		b = (byte) d;
		System.out.println("double value  =  " + d + "\nByte value = " + i);
		System.out.println("------------------------------------------------");
	}
}