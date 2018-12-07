package array;
/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 求最大子串和的方法
 */
public class MaximumSubarray_53_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {-1,0,-2};
		maxSubArray1(a);
	}
	
	//O(N)的算法复杂度
	//Kadane 算法 注意curMax soFarMax的初始值设置
	static public int maxSubArray(int[] nums) {
        
		//if(nums.length)
		int curMax=nums[0],soFarMax=nums[0];
		for(int i=1;i<nums.length;i++) {
			curMax=Math.max(nums[i], curMax+nums[i]);
			soFarMax=Math.max(soFarMax, curMax);
		}
		return soFarMax;
    }
	
	//divide and conquer approach
	static public int maxSubArray1(int[] nums) {
		if(nums.length==1)
			return nums[0];
//		int begin=0;
//		int end=nums.length-1;
		//int middle=(begin+end)/2;
		return maxSubArrayDivideAndConqure(nums,0,nums.length-1);
	}
	
	//分治算法 时间复杂度 Nlg(N)
	static int maxSubArrayDivideAndConqure(int[] nums,int begin,int end) {
		if(begin>=end)
			return nums[begin];
		int middle=(begin+end)/2;
	    int rightBorderMax=nums[middle+1],leftBorderMax=nums[middle];  //注意初始的赋值
	    int sum;
	    
	    //求 左边带边缘的 最大值
	    sum=0;
	    for(int i=middle;i>=begin;i--) {
	    	sum+=nums[i];
	    	if(sum>leftBorderMax) {
	    		leftBorderMax=sum;
	    	}
	    }
	    
	    //求 右边的带边缘的 最大值
	    sum=0;
	    for(int i=middle+1;i<=end;i++) {
	    	sum+=nums[i];
	    	if(sum>rightBorderMax){
	    		rightBorderMax=sum;
	    	}
	    }
	    System.out.println(leftBorderMax+ "  "+rightBorderMax);
	    return Math.max(rightBorderMax+leftBorderMax, Math.max(maxSubArrayDivideAndConqure(nums,begin,middle), maxSubArrayDivideAndConqure(nums,middle+1,end)));
	    
	}
	
	//O(N) 复杂度的另一种解法
	static public int maxSubArray2(int[] A) {
	    int max = Integer.MIN_VALUE, sum = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (sum < 0) 
	            sum = A[i];
	        else 
	            sum += A[i];
	        if (sum > max)
	            max = sum;
	    }
	    return max;
	}
	//Dynamic Programming DP解法 时间复杂度O(N)
	//将子任务设定为 maxSubArray(int A[], int i)   求数组 A[] 的子串A[0:i](包含A[i])的最大的子串和 并且子串中必须有A[i]
	//即将问题转化为 maxSubArray(A[], i)=maxSubArray(A[], i-1)>0 ?(maxSubArray(A[], i-1)+A[i]) : A[i]
	static public int maxSubArray3(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}
}
