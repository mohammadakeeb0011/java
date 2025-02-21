
package pack2;

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
		
		// obj2.a_default();				// class B can't call class A default
		// obj2.a_public();					// class B can't call class A public
		// obj2.a_protected();				// class B can't call class A protected
		// obj2.a_private();
		
	}
}