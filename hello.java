public class hello {
	public static void main(String[] args) {
		//System.out.print("C's ivar:" + c.ivar);
		B b = new B();
		b.getData();
	}
}

class A{
	int ivar = 7;
	private int data = 1;
	void m1() {
		System.out.print("A's m1, ");
	}
	void m2() {
		System.out.print("A's m2, ");
	}
	void m3() {
		System.out.print("A's m3, ");
	}
	public int getData() {
		System.out.println(data);
		return data;
	}
}

class B extends A {
	void m1() {
		System.out.print("B's m1, ");
	}
}

class C extends B {
	void m3() {
		System.out.print("C's m3, " + (ivar + 6));
	}
}

