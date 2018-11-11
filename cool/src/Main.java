import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
//import java.io.*;


public class Main {
	public void testInOut() {
		//import java.util.Scanner
		//初始化in:Scanner in = new Scanner(System.in);
		//整数: in.nextIne()
		//字符串: in.next()
		//浮点数: in.nextDouble()/nextFloat()
		//一行: in.nextLine()
		//阻塞判断有无输入 in.hasNext()
//      int n = in.nextInt();//整数
//      System.out.println(n);
//      
//      String s = in.next(); //字符串
//      System.out.println(s);
      
//      double d = in.nextDouble();//浮点数
//      System.out.println(d);
//      
//      float t = in.nextFloat();//浮点数
//      System.out.println(t);
//      System.out.println(in.hasNext());
//      System.out.println("shit");
//      String s = in.nextLine();//读一行
//      System.out.println(s);
		
//      System.out.println(in.hasNext());
  	//in.hasNext()  阻塞判断是否有输入
//      while (in.hasNext()) {
//	    	int intNum = in.nextInt();
//	    	int a = in.nextInt();
//	    	String s = in.next();
//	    	System.out.println(intNum);
//	    	System.out.println(a);
//	        System.out.println(s);
//      }
	}
    
	public static void recur(int i) {
		if (i <= 100) {
			System.out.println(i);
			recur(++i);
		}
		return;
	}
	
	public static void formatSwitch() {
		int i = 100;
		String s;
		//十进制->16, 8, 2进制字符串(Integet.toHexString()/toOctalString()/toBinaryString()):
		s = Integer.toHexString(i);
		System.out.println(s);
		s = Integer.toOctalString(i); 
		System.out.println(s);
		s = Integer.toBinaryString(i);
		System.out.println(s);
		//16, 8, 2->10进制进制转换(Integer.valueOf("s", m)):
		i= Integer.valueOf("FFFF",16);
		System.out.println(i);
	}
	
	public static void testQueue() {
		//import java.util.Queue
		//import java.util.LinkedList;
		//add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
//        for(String q : queue){
//            System.out.println(q);
//        }
//        System.out.println("===");
//        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
//        for(String q : queue){
//            System.out.println(q);
//        }
//        System.out.println("===");
//        System.out.println("element="+queue.element()); //返回第一个元素 
//        for(String q : queue){
//            System.out.println(q);
//        }
//        System.out.println("===");
//        System.out.println("peek="+queue.peek()); //返回第一个元素 
//        for(String q : queue){
//            System.out.println(q);
	}
	
	public static void main(String[] args) {
    	//recur(0);
    	//formatSwitch();
//    	int i = 0;
    }
}