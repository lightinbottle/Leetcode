package array;
/*
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 */

public class ShortestUnsortedContinuousSubarray_581_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,3,3,2,4};
		System.out.println(findUnsortedSubarray(a));
	}
	//第一种办法先复制一份数组 先排序nlgn 然后比较原来的数组和排序后的数组
	
	static int findUnsortedSubarray(int[] nums) {
        if(nums.length==0||nums.length==1) {
        	return 0;
        }
		int templeft=0,tempright=0;
		int i;
		for(i=1;i<nums.length;i++) {
        	if(nums[i]<nums[i-1]) {
        		templeft=i-1;
        		break;
        	}
        }
		//System.out.println(templeft);
		if(i==nums.length)
			return 0;
		for(i=nums.length-1;i>0;i--) {
        	if(nums[i-1]>nums[i]) {
        		tempright=i;
        		break;
        	}
        }
		//System.out.println(tempright);
		int tempmin=nums[templeft],tempmax=nums[tempright];
		for(i=templeft;i<=tempright;i++) {
			if(nums[i]<tempmin)
				tempmin=nums[i];
			if(nums[i]>tempmax)
				tempmax=nums[i];
		}
		//System.out.println(tempmin+ "   " +tempmax);
		int left=templeft,right=tempright;
		System.out.println(left+ "   " +right);
		System.out.println(tempmin+ "   " +tempmax);
		for(i=0;i<templeft;i++) {
			if(nums[i]>tempmin) {
				left=i;
				break;
			}
		
		}
		System.out.println(left);
		//System.out.println(templeft);
		for(i=nums.length-1;i>tempright;i--) {
			if(nums[i]<tempmax) {
				right=i;
				break;
			}
		}
		//System.out.println(right);
		
		return right-left+1;
    }
	
	//O(n)时间复杂度  只需要遍历一次数组
	public int findUnsortedSubarray1(int[] A) {
	    int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
	    for (int i=1;i<n;i++) {
	      max = Math.max(max, A[i]);
	      min = Math.min(min, A[n-1-i]);
	      if (A[i] < max) end = i;
	      if (A[n-1-i] > min) beg = n-1-i; 
	    }
	    return end - beg + 1;
	}
}
