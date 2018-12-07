package array;

import java.util.Arrays;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicatesfromSortedArray_26_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}
	static public int removeDuplicates(int[] nums) {
        if((nums.length)==0) {
        	return 0;
        }
		//int nowInt=nums[0];
		int result=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[result]) {
				result++;
				nums[result]=nums[i];
			}
		}
		return result+1;
		
    }
}
