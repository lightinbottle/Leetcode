package array;
import java.util.Arrays;
/*
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class RotateArray_189_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(a));
		rotate2(a,5);
		System.out.println(Arrays.toString(a));
	}
	static public void rotate(int[] nums, int k) {
        int temp=nums[nums.length-1];
        int index=nums.length-2;
        
        
        for(int i=0;i<k%(nums.length);i++) {
        	for(int j=0;j<nums.length-1;j++) {
        		nums[(index-j+nums.length+1)%nums.length]=nums[(index-j+nums.length)%nums.length];
        	}
        	index=(index+1)%nums.length;
        }
        nums[(index+1)%nums.length]=temp;
    }
	
	static public void rotate1(int[] nums,int k) {
		int temp=nums[nums.length-1];
		int tempIndex=nums.length-1;
		int round=1;
		
		
		int nullIndex=nums.length-1;
		for(int i=0;i<nums.length;i++) {
			if ((nullIndex-(k%nums.length)+nums.length)%nums.length==tempIndex) {
				nums[nullIndex]=temp;
				//System.out.println(tempIndex+"  "+nullIndex+"iii");
				//System.out.println(Arrays.toString(nums));
				if((nums.length-round-1)<0) {
					return;
				}
				temp=nums[nums.length-round-1];
				tempIndex=nums.length-round-1;
				nullIndex=nums.length-round-1;
				//System.out.println(nullIndex+"dvdvef");
				round++;
				continue;
			}
			//System.out.println((nullIndex-(k%nums.length)+nums.length)%nums.length);
			nums[nullIndex]=nums[(nullIndex-(k%nums.length)+nums.length)%nums.length];
			//System.out.println((nullIndex-(k%nums.length)+nums.length)%nums.length+"  "+nullIndex+"---");
			//System.out.println(Arrays.toString(nums));
			nullIndex=(nullIndex-(k%nums.length)+nums.length)%nums.length;
			
		}
	}
	
	static public void rotate2(int[] nums,int k) {
		k=k%nums.length;
		reverse(nums,0,nums.length-k-1);
		reverse(nums,nums.length-k,nums.length-1);
		reverse(nums,0,nums.length-1);
	}
	static void reverse(int[] nums, int begin, int end) {
		int temp;
		while(begin<end) {
			//System.out.println(begin+"     "+end);
			temp=nums[begin];
			nums[begin]=nums[end];
			nums[end]=temp;
			end--;
			begin++;
		}
	}
}

