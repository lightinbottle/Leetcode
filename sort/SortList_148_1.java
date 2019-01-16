package sort;

import string.AddTwoNumbers_2_1;

/*
 * Description: 利用O(nlogn)的时间复杂度和 常数级 的空间复杂度排序一个链表
 * Author: vode
 * Reference: 链表的排序 https://www.cnblogs.com/TenosDoIt/p/3666585.html
 */
public class SortList_148_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		l1.next.next.next=new ListNode(-1);
		
		ListNode ls=new SortList_148_1().sortList(l1);
		while(ls!=null) {System.out.println(ls.val);ls=ls.next;}
	}
	static class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) { val = x; }
	}
	public ListNode sortList(ListNode head) {
        //return mergeSort(head);
		quickSort(head,null);
		return head;
    }
	
	//归并排序解决  归并的时间复杂度稳定 归并排序更有效 这一题因为是链表所以空间复杂度也有O(n)变为了O(1)
	private static ListNode mergeSort(ListNode head) {
		if(head==null)return null;
		if(head.next==null)return head;
		//双指针 确定 链表的中间位置
	    ListNode prev = null, slow = head, fast = head;
	    
	    while (fast != null && fast.next != null) {
	      prev = slow;
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    prev.next = null;
		ListNode l1=mergeSort(head);
		ListNode l2=mergeSort(slow);
		return merge(l1,l2);
	}
	
	private static ListNode merge(ListNode l1,ListNode l2) {
		
		ListNode l = new ListNode(0), p = l;      //新建一个伪节点
	    
	    while (l1 != null && l2 != null) {
	      if (l1.val < l2.val) {
	        p.next = l1;
	        l1 = l1.next;
	      } else {
	        p.next = l2;
	        l2 = l2.next;
	      }
	      p = p.next;
	    }
	    
	    if (l1 != null)
	      p.next = l1;
	    
	    if (l2 != null)
	      p.next = l2;
	    
	    return l.next;
	  
	}
	
	
	//快排实现
	private static void quickSort(ListNode head,ListNode tail) {
		if(head==tail)return;
		if(head.next==tail)return;         //注意 不是head.next==null
	
		ListNode loc=partition(head,tail);
		//System.out.println(head.val+"  "+loc.val);
		quickSort(head,loc);
		quickSort(loc.next,tail);
	}
	
	public static ListNode partition(ListNode head,ListNode tail) {
		int target =head.val;
		ListNode loc=head,cursor=head.next;
		//System.out.println(head.val);
		while(cursor!=tail) {
			if(cursor.val<target){
				loc=loc.next;
				int tmp=loc.val;
				loc.val=cursor.val;
				cursor.val=tmp;
			}
			cursor=cursor.next;     //不能遗忘
		}
		head.val=loc.val;
		loc.val=target;
		return loc;
	}
	
	
}

