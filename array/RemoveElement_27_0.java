package array;

import java.util.Arrays;

/*
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

public class RemoveElement_27_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {5};
		System.out.println(removeElement1(a,5));
		System.out.println(Arrays.toString(a));
	}
	
	//两个指针
	static public int removeElement(int[] nums, int val) {
        int result=0;
        int temp;
        int begin=0,end=nums.length-1;
        while(begin<=end) {
        	while(nums[begin]!=val) {
        		begin++;
        		result++;
        		//System.out.println(result);
        		if(begin>end) {
        			//System.out.println(result);
        			return result;
        		}
        	}
        	while(nums[end]==val) {
        		end--;
        		if(begin>end) {
        			return result;
        		}
        	}
        	temp=nums[end];
        	nums[end]=nums[begin];
        	nums[begin]=temp;
        }
        return result;
    }
	//best
	static public int removeElement1(int[] nums, int val) {
		int begin=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[begin]=nums[i];
				begin++;
			}
		}
		return begin;
	}
	
}
