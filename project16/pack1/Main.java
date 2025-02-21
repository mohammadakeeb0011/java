
package pack1;

class Main {
	public static void main(String args[]) {
		A obj1 = new A();
		B obj2 = new B();
		
		obj1.a_default();
		obj1.a_public();
		obj1.a_protected();
		// obj1.a_private();			error: a_private() has private access in A
		
		obj2.b_default();
		obj2.b_public();
		obj2.b_protected();
		// obj2.b_private();
		
		obj2.a_default();
		obj2.a_public();
		obj2.a_protected();
		// obj2.a_private();
		
	}
}