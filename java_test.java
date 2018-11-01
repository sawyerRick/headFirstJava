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

//接口: 实现了继承一个以上的类(某类还可以扮演某个类)
interface Pet {
	// public abstract可以省略, 默认就是public abstract
	public abstract void play();
	void beFriendly();
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
	public void testOverWrite() {
		System.out.println("Animal's method");
	}
}

// x继承自y : x extends y  (public继承private不继承)
class Dog extends Animal {
	private int size = 5;
	//覆盖(必须履行覆盖规则--返回值类型和参数个数必须一致): 直接重写
	public void makeNoise() {
		System.out.println("wang wang wang!!!");
	}
	public void sayFuck() {
		System.out.println("fuck");
	}
	public void testOverWrite() {
		System.out.println("Dog's method");
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

class Hippo extends Animal implements Pet {
	public void makeNoise() {
		System.out.println("I am making noise...");
	}
	public void play() {
		System.out.println("I am playing");
	}
	public void beFriendly() {
		System.out.println("I am friendly");
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
		
		//编译器只根据引用类型来判断有哪些method可以用, 而不是对象类型
		//Animal dog = new Dog();
		//dog.sayFuck();
		//Dog trueDog = new Dog();
		//trueDog.sayFuck();
		
		//父类声明过的可以使用/也可以被覆盖
		//Animal dog = new Dog();
		//dog.testOverWrite();
		
		//转换成Dog, 拷贝一个Dog引用, 就可以使用了
		//用instanceof来检查引用的对象是不是Dog
//		Animal dog = new Dog();
//		if (dog instanceof Dog) {
//			Dog copyDog = (Dog) dog;
//			copyDog.sayFuck();
//		}
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
