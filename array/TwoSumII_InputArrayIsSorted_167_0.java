package array;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted_167_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,7,11,15,17,19};
		System.out.println(Arrays.toString(twoSum2(a,26)));

	}
	
	//1. Time Limit Exceeded  O(N^2)
	static public int[] twoSum1(int[] numbers, int target) {
        int[] result =new int[2];
        int i,j;
		for(i=0;i<numbers.length;i++) {
			for(j=i+1;j<numbers.length;j++) {
				if(numbers[i]+numbers[j]==target) {
					result[0]=i+1;
					result[1]=j+1;
					return result;
				}
			}
		}
		return result;
    }
	//2.先判断搜索边界
	static public int[] twoSum(int[] numbers, int target) {
        int[] result =new int[2];
        int begin = 0,end=0;
        int i,j;
        
        for(i=0;i<numbers.length;i++) {
        	if(numbers[i]>=target-numbers[numbers.length-1]) {
        		begin=i;
        		System.out.println(i);
        		break;
        	}
        }
        for(i=numbers.length-1;i>=0;i--) {
        	if(numbers[i]<=target-numbers[0]) {
        		end=i;
        		System.out.println(i);
        		break;
        	}
        }
      
		for(i=begin;i<end;i++) {
			for(j=i+1;j<=end;j++) {
				if(numbers[i]+numbers[j]==target) {
					result[0]=i+1;
					result[1]=j+1;
					return result;
				}
			}
		}
		return result;
    }
	//3.利用二分搜索
	/*
	 * fix the first element A[0] and do binary search on the remaining n-1 elements. If cannot find any element which equals target-A[0], Try A[1]. That is, fix A[1] and do binary search on A[2]~A[n-1]. 
	 * Continue this process until we have the last two elements A[n-2] and A[n-1].
	 * Does this gives a time complexity lg(n-1) + lg(n-2) + ... + lg(1) ~ O(lg(n!)) ~ O(nlgn). So it is less efficient than the O(n) solution.
	 */
	
	//4. two pointers O(N)
	static public int[] twoSum2(int[] numbers, int target) {
		int[] result =new int[2];
        int begin=0,end=numbers.length-1;
        while(begin<end){
        	if(numbers[begin]+numbers[end]==target) {
        		result[0]=begin+1;
        		result[1]=end+1;
        		return result;
        	}else if(numbers[begin]+numbers[end]<target) {
        		begin++;
        	}else {
        		end--;
        	}
        }
        
		return result;
    }

}
