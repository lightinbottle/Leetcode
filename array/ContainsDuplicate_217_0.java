package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate_217_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,2};
		System.out.println(containsDuplicate(a));
	}
	
	//简单的方法是 新建一个HashSet 依次插入 如果在重复插入 就返回True
	//时间复杂度=空间复杂度=O(N)
	static public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(!set.contains(nums[1])) {
        		set.add(nums[1]);
        	}else {
        		return true;
        	}
        }
        return false;
    }
	
	//如果有空间复杂度限制 就先排序 再判断
	//时间依赖于排序算法  空间复杂度O(1)
	static public boolean containsDuplicate1(int[] nums) {
		if(nums.length==0) {
			return false;
		}
		Arrays.sort(nums);
		int curr=nums[0];
		for(int i=1; i<nums.length;i++) {
			if(nums[i]==curr) {
				return true;
			}else {
				curr=nums[i];
			}
		}
		return false;
	}
	
	
}
