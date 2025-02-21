import pack3.A;
class Main {
	public static void main(String args[]) {
		A obj1 = new A();
		
		// obj1.a_default();  // error: a_default() is not public in A; cannot be accessed from outside package
		obj1.a_public();
		// obj1.a_protected();
		// obj1.a_private();			error: a_private() has private access in A
	
		
	}
}