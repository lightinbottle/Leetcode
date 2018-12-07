package array;

import java.util.Scanner;
import java.util.Arrays;

public class SearchInsertPosition_35_0 {

	public static void main(String[] args) {
		int[] a= {1};
		System.out.println(searchInsert(a,9));
	}
	static int searchInsert(int[] nums, int target) {
//		int result =Arrays.binarySearch(nums,target);
//		if(result>=0) {
//			return result;
//		}else {
//			return -result-1;
//		}
		int low=0;
		int high=nums.length-1;
		int mid,midValue;
		while(low<=high) {
			mid =(low+high)>>>1;
			midValue=nums[mid];
			if(target>midValue) {
				low=mid+1;
			}else if(target<midValue) {
				high=mid-1;
			}else {
				return mid;
			}
		}
		return low;
	}

}
