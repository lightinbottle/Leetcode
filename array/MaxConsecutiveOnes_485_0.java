package array;
/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */

import java.util.Arrays;

public class MaxConsecutiveOnes_485_0 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(a));
		
	}
	static int findMaxConsecutiveOnes(int[] nums) {
        int currentMax=0,max=0;
        for(int a:nums) {
        	if(a==0) {
        		currentMax=0;
        	}
        	if(a==1) {
        		currentMax++;
        		max=currentMax>max?currentMax:max;
        	}
        }  
        return max;
    }
}
