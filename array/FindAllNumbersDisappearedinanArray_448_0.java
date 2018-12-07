package array;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */

public class FindAllNumbersDisappearedinanArray_448_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
	}
	
	//解法的要求是空间复杂度 O(1)  时间复杂度O(n)
	//利用原始的数组 nums[] 来存储 那些数字有 哪些数字没有 
	static public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list=new ArrayList<Integer>();
		int temp;
		for(int i=0;i<nums.length;i++) {
        	temp=Math.abs(nums[i]);
        	if(nums[temp-1]>0)
        		nums[temp-1]=-nums[temp-1];
        }
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]>0) {
        		list.add(i+1);
        	}
        }
        return list;
    }	
	
	static public List<Integer> findDisappearedNumbers1(int[] nums) {
		List<Integer> list=new ArrayList<Integer>();
		int temp;
		int n=nums.length+1;
		for(int i=0;i<n-1;i++) {
        	temp=nums[i]%n;
        	if(nums[temp-1]<n)
        		nums[temp-1]+=n;
        }
        for(int i=0;i<n-1;i++) {
        	if(nums[i]<n) {
        		list.add(i+1);
        	}
        }
        return list;
    }
}
