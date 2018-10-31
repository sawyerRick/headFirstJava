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

//����Ҫ��д��ͷ/�����������շ�
//abstract:������
abstract class Animal {
	private int size = 0;
	public void setSize(int s) {
		size = s;
	}
	public int getSize() {
		return size;
	}
	//�������ط���
	public void testOverLoad() {
		System.out.println("Waiting for overloading...");
	}
	//��ȷ���ط���(�����������벻ͬ,����ֵ�������):
	public void testOverLoad(int n) {
		System.out.println(n);
	}
	//��ȷ���ط���:
		public int testOverLoad(int n, int m) {
			System.out.println(n);
			return 1;
		}
	// abstract : ���󷽷�, ���ű�����(��������!!!)
	abstract public void makeNoise();
}

// x�̳���y : x extends y  (public�̳�private���̳�)
class Dog extends Animal {
	private int size = 5;
	//����(�������и��ǹ���--����ֵ���ͺͲ�����������һ��): ֱ����д
	public void makeNoise() {
		System.out.println("wang wang wang!!!");
	}
}

class Cat extends Animal {
	private int size = 6;
	//����(�����������벻ͬ): ��д(������ͬ||����ֵ����)��ͬ�ĺ���
	//���ش����÷�(��Ը�����):
	public int testOverLoad(int a, int b) {
		System.out.println(a + b);
		return 1;
	}
	//����(�������и��ǹ���--����ֵ���ͺͲ�����������һ��): ֱ����д
	public void makeNoise() {
		System.out.println("miao miao miao!!!");
	}
}

class TestSomething{
	public void testAnimal() {
		//��̬: ��Animal���ñ���װDog����
		Animal[] animalVector = new Animal[2];
//      Ϊʲô��������???��̬���ò�������������???
//		��Ϊ���������һ����֮�ڵ�==>һ�����ڶ��(����������ͬ||����ֵ���Ͳ�ͬ)����
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
		// ����0~n֮�ڵ������ :Math.random() * n
		int random = (int)(Math.random() * 10);
		System.out.println(random);
	}
	public void testForAndString() {
		// �ռ�forѭ�� :for (int i: somwhere) {}
		String[] someString = new String[2];
		someString[0] = "fuck";
		someString[1] = "shit";
		for (String s: someString) {
			System.out.println(s);
		}
	}
	public void testArrayList() {
		//add, remove, contains, isEmpty, indexOf, size, get, 
		//Java��������:
		//������������(ʵ��): boolean��char��byte��short��int��long��float��double
		//��װ������(��)��Boolean��Character��Byte��Short��Integer��Long��Float��Double
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
		
//		Ϊʲô��String���캯��/û��Integer���캯������
//		String a_string = new String();
//		String b_string = "fuck";
//		Float Integer = new Integer();
	}
	public void testObject() {
		//�ռ�����Object(������Դ)
		Dog a_dog = new Dog();
		Dog b_dog = new Dog();
		System.out.println(b_dog.equals(a_dog));
		System.out.println(a_dog.getClass());
		System.out.println(a_dog.hashCode());
		System.out.println(a_dog.toString());
	}
}
