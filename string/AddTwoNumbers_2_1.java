package string;

public class AddTwoNumbers_2_1 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		
		
		ListNode ls=new AddTwoNumbers_2_1().addTwoNumbers(l1, l2);
		while(ls!=null) {System.out.println(ls.val);ls=ls.next;}
		
	}
	static class ListNode {
		int val;
	 	ListNode next;
	 	ListNode(int x) { val = x; }
	}
	
	//faster than 82.92%
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode first=result;
        
        int carry=0;
        while(l1!=null||l2!=null) {
        	int int1=l1==null?0:l1.val;
        	int int2=l2==null?0:l2.val;
        	if(l1!=null)l1=l1.next;
        	if(l2!=null)l2=l2.next;
        	
        	//System.out.println(int1+"  "+int2+"  "+carry);
        	result.next=new ListNode((int1+int2+carry)%10);
        	
        	carry=(int1+int2+carry)/10;
        	result=result.next;
        }
        if(carry!=0)result.next=new ListNode(carry);
        return first.next;
    }
	
	//减少变量的使用
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode first=result;
        
        int sum=0;
        while(l1!=null||l2!=null) {
        	if(l1!=null) {sum+=l1.val;l1=l1.next;}
        	if(l2!=null) {sum+=l2.val;l2=l2.next;}
        	//System.out.println(int1+"  "+int2+"  "+carry);
        	result.next=new ListNode((sum)%10);
        	
        	sum/=10;
        	result=result.next;
        }
        if(sum!=0)result.next=new ListNode(sum);
        return first.next;
    }
}
