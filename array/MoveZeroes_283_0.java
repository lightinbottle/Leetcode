package array;

import java.util.Arrays;

public class MoveZeroes_283_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,0,0,1,0,3,0,9,21,0,6};
		movezeros(a);
		System.out.println(Arrays.toString(a));

	}
	static void movezeros(int[] nums) {
		int zeroIndex=0,noZeroIndex=0;
		int temp;
		while(noZeroIndex<nums.length&&zeroIndex<nums.length) {   
			while(nums[zeroIndex]!=0) {
				zeroIndex++;
				if(zeroIndex>=nums.length)
					return;
			}
			if(noZeroIndex>zeroIndex) {
				noZeroIndex++;
			}else {
				noZeroIndex=zeroIndex+1;
			}
			if(noZeroIndex>=nums.length)
				return;
			while(nums[noZeroIndex]==0) {
				noZeroIndex++;
				if(noZeroIndex>=nums.length)
					return;
			}
			temp=nums[zeroIndex];
			nums[zeroIndex]=nums[noZeroIndex];
			nums[noZeroIndex]=temp;
		}
	}
}
