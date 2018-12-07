package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), 
 * where i and j are both numbers in the array and their absolute difference is k. 
 */
public class KdiffPairsInAnArray_532_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,1,1,2,1};
		System.out.println(findPairs(a,1));
	}
	static int findPairs(int[] nums, int k) {
		if(k<0) {
			return 0;
		}
		int count=0;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int a:nums) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(k==0) {
				if(entry.getValue()>=2) {
					count++;
				}
			}else {
				if(map.containsKey(entry.getKey()+k)) {
					count++;
				}
			}
			
		}
		return count;
	}
    

}
