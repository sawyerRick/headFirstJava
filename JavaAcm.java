import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class ListNode{
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
	//thisָ����
	public void testThis() {
		System.out.println(this.val);
	}
}

//��ͷ��������(�����ײ�)(this����Ĭ���׽��)
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
        MyLinkedList curr = this.next;//�׽ڵ���һ����ʼ
    	
        //δƥ��index��δ����������
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
    	//�ײ巨
    	MyLinkedList temp = this.next;
    	this.next = new MyLinkedList(val);
    	this.next.next = temp;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	//β�巨
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
    		//ǰ��
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
		//ɾ�������ظ�Ԫ��
		/*
		 ʾ�� 1:
		����: 1->1->2
		���: 1->2
		ʾ�� 2:
		����: 1->1->2->3->3
		���: 1->2->3
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
		//����ָ��(ģ�������ܲ�)
		//���û��l.next�Ͳ���l.next.next ==> �ж�l.next.next ==> if (fast.next == null || fast.next.next == null)
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
		//ֻ����һ�ε�����, ��λ���, ��ͬ����, ��ͬ������
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }
	
	public static void xor() {
		//!!!��λ!!!�������(��ͬ��0��ͬ��1):
		int result = 0;
		System.out.println(result ^ 100);
	}
	
	public static boolean hasCycle(ListNode head) {
		//�жϻ�������, ��HashSet������, ��set.contains()���жϻ�ȽϿ�
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
		//��ϣ����(HashSet):
		Set<Integer> set = new HashSet<>();
		int[] nums = {1, 2, 3};
		//�����ϣ��:System.out.println(nums.toString());
		//ֱ���������:System.out.println(Arrays.toString(nums));
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
		//���������ж�:
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = head;
		//�������
		System.out.printf("head:%s  head.next.next:%s\r\n", head, head.next.next);
		if (head.next.next == head){
			System.out.println("cool");
		}
	}
}