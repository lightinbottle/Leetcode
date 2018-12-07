package array;

import java.util.Arrays;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray_88_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,0};
		int[] b= {2};
		merge(a,1,b,1);
		System.out.println(Arrays.toString(a));
	}
	
	//beats 100%  线性的算法复杂度
	static public void merge(int[] nums1, int m, int[] nums2, int n) {
        
		int i=m-1,j=n-1;
		int k=n+m-1;
		
		while(i>=0&&j>=0) {
			if(nums1[i]>nums2[j]) {
				nums1[k]=nums1[i];
				i--;
			}else {
				nums1[k]=nums2[j];
				j--;
			}	
			k--;
		}
		if(j>=0) {
			
			nums1[k]=nums2[j];
			k--;
			j--;
		}
		
    }
}
