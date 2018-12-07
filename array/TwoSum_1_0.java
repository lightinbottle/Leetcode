package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum_1_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(twoSum(new int[] {1,2,5,8,20,31},32)));
	}
	static public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> mapp=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++) {
        	if(!mapp.containsKey(nums[i]))
        		mapp.put(target-nums[i], i);
        	else {
        		result[0]=mapp.get(nums[i]);
        		result[1]=i;
        		return result;
        	}	
        }
        return result;
    }
}
