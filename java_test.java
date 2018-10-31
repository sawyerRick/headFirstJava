import java.util.ArrayList;

public class java_test {
	public static void main(String[] args) {
		TestSomething thing = new TestSomething();
		//thing.testRandom();
		//thing.testForAndString();
		//thing.testArrayList();
		//thing.testObject();
		thing.testAnimal();
	}
}

//类名要大写开头/其他名字骆驼峰
//abstract:抽象类
abstract class Animal {
	private int size = 0;
	public void setSize(int s) {
		size = s;
	}
	public int getSize() {
		return size;
	}
	//测试重载方法
	public void testOverLoad() {
		System.out.println("Waiting for overloading...");
	}
	//正确重载方法(参数个数必须不同,返回值类型随便):
	public void testOverLoad(int n) {
		System.out.println(n);
	}
	//正确重载方法:
		public int testOverLoad(int n, int m) {
			System.out.println(n);
			return 1;
		}
	// abstract : 抽象方法, 等着被覆盖(不能重载!!!)
	abstract public void makeNoise();
}

// x继承自y : x extends y  (public继承private不继承)
class Dog extends Animal {
	private int size = 5;
	//覆盖(必须履行覆盖规则--返回值类型和参数个数必须一致): 直接重写
	public void makeNoise() {
		System.out.println("wang wang wang!!!");
	}
}

class Cat extends Animal {
	private int size = 6;
	//重载(参数个数必须不同): 重写(参数不同||返回值类型)不同的函数
	//重载错误用法(面对父子类):
	public int testOverLoad(int a, int b) {
		System.out.println(a + b);
		return 1;
	}
	//覆盖(必须履行覆盖规则--返回值类型和参数个数必须一致): 直接重写
	public void makeNoise() {
		System.out.println("miao miao miao!!!");
	}
}

class TestSomething{
	public void testAnimal() {
		//多态: 用Animal引用变量装Dog对象
		Animal[] animalVector = new Animal[2];
//      为什么不能这样???多态引用不能用子类重载???
//		因为重载是面对一个类之内的==>一个类内多个(参数个数不同||返回值类型不同)方法
//		Animal cat = new Cat();
//		cat.testOverLoad(1, 2);
		Cat cat = new Cat();
		cat.testOverLoad(1, 2);
		
		
		animalVector[0] = new Dog();
		animalVector[1] = new Cat();
		for (Animal animal:animalVector) {
			animal.makeNoise();
		}
	}
	public void testRandom() {
		// 产生0~n之内的随机数 :Math.random() * n
		int random = (int)(Math.random() * 10);
		System.out.println(random);
	}
	public void testForAndString() {
		// 终极for循环 :for (int i: somwhere) {}
		String[] someString = new String[2];
		someString[0] = "fuck";
		someString[1] = "shit";
		for (String s: someString) {
			System.out.println(s);
		}
	}
	public void testArrayList() {
		//add, remove, contains, isEmpty, indexOf, size, get, 
		//Java数据类型:
		//基本数据类型(实例): boolean，char，byte，short，int，long，float，double
		//封装类类型(类)：Boolean，Character，Byte，Short，Integer，Long，Float，Double
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<Float> floatList = new ArrayList<Float>();
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		ArrayList<Double> doubleList = new ArrayList<Double>();
		ArrayList<Dog> animalList = new ArrayList<Dog>();
		
		Dog dog = new Dog();
		animalList.add(dog);
		
		intList.add(1);
		intList.add(2);
		System.out.println(intList);
		System.out.println(intList.get(intList.indexOf(2)));
		System.out.println(intList.isEmpty());
		System.out.println(intList.size());
		System.out.println(intList.contains(2));
		System.out.println(intList.remove(1));
		System.out.println(intList);
		
//		为什么有String构造函数/没有Integer构造函数？？
//		String a_string = new String();
//		String b_string = "fuck";
//		Float Integer = new Integer();
	}
	public void testObject() {
		//终极对象Object(万物起源)
		Dog a_dog = new Dog();
		Dog b_dog = new Dog();
		System.out.println(b_dog.equals(a_dog));
		System.out.println(a_dog.getClass());
		System.out.println(a_dog.hashCode());
		System.out.println(a_dog.toString());
	}
}
