// Demonstrating boolean values

class BoolTest{
	public static void main(String args[]){
		boolean b;
		
		b = false;
		System.out.println("b is " + b);
		b = true;
		System.out.println("b is " + b);
		
		// boolean value can control if statements
		if(b)
			System.out.println("This is executed.");
		b = false;
		if(b)
			System.out.println("This is not executed.");
		
		// output of a relation operator is a boolean value
		System.out.println("10 > 9 is " + (10 > 9));
	}
}