package array;
/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n)
 * 返回第三大的数 如果不存在 就返回最大的数
 */

import java.util.Arrays;

public class ThirdMaximumNumber_414_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(thirdMax(new int[] {1,2,2,-2147483648}));
	}
	
	//遍历数组三次 找到第三大的
	
	//遍历一次 找到第三大的
	static public int thirdMax(int[] nums) {
			
	        Integer first=null;
	        Integer second=null;
	        Integer third=null;
	        
	        for(int i=0;i<nums.length;i++){
	        	if(first==null||nums[i]>first){
	        		third=second;
	        		second=first;
	        		first=nums[i];
	        		//System.out.println(first+" "+second+" "+third);
	        	}else if(second==null||nums[i]>second){
	        		if(nums[i]==first)
	        			continue;
	        		third=second;
	        		second=nums[i];
	        		//System.out.println(first+" "+second+" "+third);
	        	}else if(third==null||nums[i]>third){
	        		if(nums[i]==second)
	        			continue;
	        		third=nums[i];
	        		//System.out.println(first+" "+second+" "+third);
	        	}
	        }
	        if(third==null) {
	        	return first;
	        }else {
	        	return third;
	        }
	}
}
