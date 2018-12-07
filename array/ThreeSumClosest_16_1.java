package array;

import java.util.Arrays;

/*
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */

/*
 * 经典的3Sum的问题
 */
public class ThreeSumClosest_16_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//算法复杂度 O(n^2)
	static int threeSumClosest(int[] nums, int target) {
        int result=nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        int second,third,sum;
        for(int i=0;i<nums.length-2;i++) {
        	second=i+1;
        	third=nums.length-1;
        	while(second<third) {
        		sum=nums[i]+nums[second]+nums[third];
        		if(sum>target){
        			third--;
        		}else {
        			second++;
        		}
        		if(Math.abs(sum-target)<Math.abs(result-target)) {
        			result=sum;
        		}
        	}
        }
        return result;
    }
}
