package string;

import string.AddTwoNumbers_2_1.ListNode;

public class AddTwoNumbersII_445_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(7);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		l1.next.next.next=new ListNode(3);
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		
		
		ListNode ls=new AddTwoNumbersII_445_1().addTwoNumbers(l1, l2);
		while(ls!=null) {System.out.println(ls.val);ls=ls.next;}
	}
	static class ListNode {
		int val;
	 	ListNode next;
	 	ListNode(int x) { val = x; }
	}
	//跟AddTwoNumbers_2_1 类似
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp,pre=null;
        
        //将l1 l2翻转 就将该问题 转化为了AddTwoNumbers_2_1
		while(l1.next!=null) {
        	tmp=l1.next;
        	l1.next=pre;
        	pre=l1;
        	l1=tmp;
        }
		l1.next=pre;
		pre=null;
		while(l2.next!=null) {
        	tmp=l2.next;
        	l2.next=pre;
        	pre=l2;
        	l2=tmp;
        }
		l2.next=pre;
		
		while(l1!=null) {System.out.println(l1.val);l1=l1.next;}
		while(l2!=null) {System.out.println(l2.val);l2=l2.next;}
		return new ListNode(5);
    }
}
