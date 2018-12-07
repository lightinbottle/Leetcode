package array;
/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 * 注意审题是： at most k 也就是 i,j差值可以小于或等于k  只要存在一组i，j使得 nums[i]=nums[j],|j-i|<=k 则返回true !!!
 */

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII_219_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,1,2,3};
		System.out.println(containsNearbyDuplicate(a,2));

	}
	//利用HashMap 时间复杂度=空间复杂度=O(N)
	static public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}else {
				if(i-map.get(nums[i])<=k)
					return true;
				else 
					map.put(nums[i], i);		
			}
		}
		return false;
	}
}
