package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(a,0));
	}
	
	//https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA   KSum
	static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int len=nums.length;
        if(len<4||nums==null)return result;
        int sum=0;
        Arrays.sort(nums);
        int third,fourth;
        for(int i=0;i<nums.length-3;i++) {
        	for(int j=i+1;j<nums.length-2;j++) {
        		third=j+1;
        		fourth=nums.length-1;
        		while(third<fourth) {
        			sum=nums[i]+nums[j]+nums[third]+nums[fourth];
            		if(sum>target) {
            			fourth--;
            		}else if(sum<target) {
            			third++;
            		}else {
            			result.add(Arrays.asList(nums[i],nums[j],nums[third],nums[fourth]));
            			while(third<fourth&&nums[fourth-1]==nums[fourth]) fourth--;
            			while(third<fourth&&nums[third+1]==nums[third]) third++;
            			fourth--;
            			third++;
            		}
        		}
        		while(j<nums.length-2&&nums[j]==nums[j+1])
        			j++;
        	}
        	while(i<nums.length-3&&nums[i]==nums[i+1])
        		i++;
        }
        return result;
              
    }
}
