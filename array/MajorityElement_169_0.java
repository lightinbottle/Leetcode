package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class MajorityElement_169_0 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int[] a= {1,0,1,0,1};
		System.out.println(majorityElement2(a));
	}
	//先排序 算法复杂度 依赖于排序算法 快排 O(NlgN)
	static public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       return nums[nums.length/2];
    }
	
	//借助于Map  存储每个元素出现的次数 时间复杂度O(N)
	static public int majorityElement1(int[] nums) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int len=nums.length;
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i],1);
			}
			if(map.get(nums[i])>len/2) {
				return nums[i];
			}
		}
		return 0;
	}
	
	//这个问题就是一个投票问题 可以使用 Moore’s voting algorithm 投票算法
	//一个时间复杂度是线性的投票算法
	//算法的前提是 一定存在一个个数大于 n/2的 元素
	//每次 选择一对 不同的元素 删除，直达最后剩下0个或1个元素
	static public int majorityElement2(int[] nums) {
		
		int majority=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++) {
			if(count==0) {
				count=1;
				majority=nums[i];
				continue;
			}
			if(nums[i]!=majority) {
				count--;
			}else {
				count++;
			}
		}
		return majority;
	}
}
