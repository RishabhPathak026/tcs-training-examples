package com.tcs.streams;

interface A {
	void test();
}
class B {
	public void hello() {
		System.out.println("hello() inside B");
	}
}
class C {
	public void demo() {
		System.out.println("demo() inside B");
	}
}

public class TestMethodReference {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		A a1 = b :: hello;
		welcome(a1);
		A a2 = c :: demo;
		welcome(a2);
		// providing new implementation
		A a3 = () -> System.out.println("test() is implemented");
		welcome(a3);
	}
	public static void welcome(A a) {
		a.test();
	}
}
