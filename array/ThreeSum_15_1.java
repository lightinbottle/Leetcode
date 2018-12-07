package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(a));
	}
	static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums.length<3) {
        	return result;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int second,third;
        for(int i=0;i<nums.length-2;i++) {
        	// System.out.println(i);
        	//System.out.println(result);
        	if(nums[i]>0) {
        		break;
        	}
        	second=i+1;
        	third=nums.length-1;
        	
        	while(second<third) {
        		//System.out.println(second+"   "+third);
        		int sum=nums[i]+nums[second]+nums[third];
            	if(sum>0) {
            		third--;
            	}else if(sum<0){
            		second++;
            	}else {
            		result.add(Arrays.asList(nums[i],nums[second],nums[third]));
            		while(second<third&&nums[second]==nums[second+1])
            			second++;
            		while(second<third&&nums[third]==nums[third-1])
            			third--;
            		second++;
            		third--;
            	}	
        	}
        	while(nums[i+1]==nums[i]&&i<nums.length-2)
        		i++;
        }
        return result;
    }
}
