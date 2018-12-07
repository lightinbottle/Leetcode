package array;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 要求：O(n)时间复杂度 O(1)空间复杂度
 */

import java.util.Arrays;

public class MissingNumber_268_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b= {9,6,4,2,3,5,7,0,1};
		System.out.println(missingNumber(b));
	}
	static public int missingNumber(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) {
        	sum+=nums[i];
        }
        return (nums.length*(nums.length+1)/2)-sum;
    }

}
