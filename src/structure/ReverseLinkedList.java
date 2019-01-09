package structure;

public class ReverseLinkedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ReverseLinkedList() {}
	
	public ListNode construct(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;
		ListNode head;
		ListNode node = new ListNode(arr[0]);
		node.next = null;
		head = node;
		for (int i = 1; i < arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		node.next = null;
		return head;
	}
	
	public ListNode reverse(ListNode head) {
		if (head == null)
			return null;
		ListNode p, q, r;
		p = head;
		q = head.next;
		if (q != null) {
			r = q.next;
			p.next = null;
			while (r != null) {
				q.next = p;
				p = q;
				q = r;
				r = r.next;
			}
			q.next = p;
			p = q;
		}
		
		return p;
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null)
    		return null;
    	if (m == n || m < 0 || n < 0 || m > n)
    		return head;
    	
    	ListNode pre, post, p, q, r;
    	pre = head;
		p = head;
    	
    	int count = 1;
    	while (count < m) {
    		if (count > 1)
    			pre = pre.next;
    		p = p.next;
    		count++;
    	}
    	post = pre.next;
    	if (m == 1) {
    		pre = null;
    		post = head;
    	}	
    	
    	q = p.next;
    	if (q != null) {
			r = q.next;
			p.next = null;
			while (r != null && count < n-1) {
				q.next = p;
				p = q;
				q = r;
				r = r.next;
				count++;
			}
			q.next = p;
			p = q;
			post.next = r;
		}
    	if (pre == null)
    		head = p;
    	else
    		pre.next = p;
		
        return head;
    }
    
    public ListNode reverseBetween2(ListNode head, int m, int n) {
    	if (head == null)
    		return head;
 	
    	ListNode reverseList = new ListNode(-1);
    	reverseList.next = head;
    	
    	ListNode pre = reverseList;
    	for(int i = 1; i < m; i++) 
    		pre = pre.next;
    	
    	ListNode curr = pre.next;
    	for(int i = m; i < n; i++) {
    		ListNode next = curr.next;
    		curr.next = next.next;
    		next.next = pre.next;
    		pre.next = next;
    	}
    	return reverseList.next;
    }
	
	public void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.printf("%d ", node.val);
			node = node.next;
		}
			
		System.out.println();
	}
	
	public static void test() {
		int[] arr = {1, 2, 3, 4, 5};
		//int[] arr2 = {1};
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode list = rll.construct(arr);
		rll.printList(list);
		list = rll.reverse(list);
		rll.printList(list);
	}
	
	public static void test2() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		//int[] arr2 = {1,2};
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode list = rll.construct(arr);
		rll.printList(list);
		list = rll.reverseBetween2(list, 1, 7);
		rll.printList(list);
	}
	
	public static void main(String[] args) {
		test2();
	}
}
