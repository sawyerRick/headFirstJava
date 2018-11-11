import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class ListNode{
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
	//this指向本身
	public void testThis() {
		System.out.println(this.val);
	}
}

//带头结点的链表(方便首插)(this就是默认首结点)
class MyLinkedList {
	int val;
	MyLinkedList next;
	
	MyLinkedList(int v) {
		val = v;
		next = null;
	}
	
	MyLinkedList() {
		val = 0;
		next = null;
	}
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if (index < 0) {
    		return -1;
    	}
    	int i = 0;
        MyLinkedList curr = this.next;//首节点下一个开始
    	
        //未匹配index且未遍历完链表
        while (i != index && curr.next != null) {
        	curr = curr.next;
        	i++;
        }
        if (i == index && curr != null) {
        	return curr.val;
        }
        else {
        	return -1;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	//首插法
    	MyLinkedList temp = this.next;
    	this.next = new MyLinkedList(val);
    	this.next.next = temp;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	//尾插法
    	MyLinkedList curr = this.next;
        while (curr.next != null) {
        	curr = curr.next;
        }
        curr.next = new MyLinkedList(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if (index < 0) {
    		return;
    	}
    	MyLinkedList curr = this;
    	int i = 0;
    	while (i != index && curr != null) {
    		i++;
    		curr = curr.next;
    	}
    	if (index == i && curr != null) {
    		//前插
    		MyLinkedList temp = curr.next;
    		curr.next = new MyLinkedList(val);
    		curr.next.next = temp;
    		System.out.println("aaa");
    	}
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i = 0;
        MyLinkedList curr = this;
        while (i != index && curr != null) {
    		i++;
    		curr = curr.next;
    	}
        if (index == i && curr != null) {
    		curr.next = curr.next.next;
    	}
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class JavaAcm{
	
	public static ListNode deleteDuplicates(ListNode head) {
		//删除链表重复元素
		/*
		 示例 1:
		输入: 1->1->2
		输出: 1->2
		示例 2:
		输入: 1->1->2->3->3
		输出: 1->2->3
		 */
	       ListNode curr = head;
			while (curr != null && curr.next != null) {
				if (curr.val == curr.next.val) {
					curr.next = curr.next.next;
				}
	            else {
	                curr = curr.next;
	            }
			}
			return head;
	    }
	
	public static boolean hasCycle2(ListNode head) {
		//快慢指针(模拟两人跑步)
		//如果没有l.next就不能l.next.next ==> 判断l.next.next ==> if (fast.next == null || fast.next.next == null)
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
		ListNode slow = head;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return true;
    }
	
	public static int singleNumber(int[] nums) {
		//只出现一次的数字, 按位异或, 相同清零, 不同的留下
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }
	
	public static void xor() {
		//!!!按位!!!异或运算(相同则0不同则1):
		int result = 0;
		System.out.println(result ^ 100);
	}
	
	public static boolean hasCycle(ListNode head) {
		//判断环形链表, 用HashSet来保存, 用set.contains()来判断会比较快
        Set<ListNode> nodesSeen = new HashSet<>();
        nodesSeen.add(head);
        while (head != null) {
            head = head.next;
            if (nodesSeen.contains(head)) {
                return true;
            }
            else {
                nodesSeen.add(head);
            }
        }
        return false;
    }
	
	public static void testHashSet() {
		//哈希集合(HashSet):
		Set<Integer> set = new HashSet<>();
		int[] nums = {1, 2, 3};
		//对象哈希码:System.out.println(nums.toString());
		//直接输出数组:System.out.println(Arrays.toString(nums));
		set.add(1);
		System.out.println(set.contains(1));
		System.out.println(set.toString());
	}
	
	public static void main(String[] args) {
		//System.out.println("hello");
		//testLink();
		//testHashSet();
		//xor();
		MyLinkedList link = new MyLinkedList();
		link.addAtIndex(1, 2);
		//link.addAtIndex(0, 1);
		//System.out.println(link.get(0));
		//System.out.println(link.get(1));
		//link.deleteAtIndex(0);
		//[0],[1,2],[0],[1],[0,1],[0],[1]

	}
	public static void testLink() {
		//环形链表判断:
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = head;
		//对象相等
		System.out.printf("head:%s  head.next.next:%s\r\n", head, head.next.next);
		if (head.next.next == head){
			System.out.println("cool");
		}
	}
}