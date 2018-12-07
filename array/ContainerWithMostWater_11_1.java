package array;

public class ContainerWithMostWater_11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//两个游标 算法复杂度为O(N),通过逻辑推理 证明 可以减少运算的次数
	static int maxArea(int[] height) {
		int left=0,right=height.length-1;
		int maxArea=0;
		while(left<right) {
			maxArea=Math.max(maxArea, (right-left)*Math.min(height[left], height[right]));
			if(height[left]>height[right]) {
				right--;
			}else {
				left++;
			}
		}
		return maxArea;
	}
	//https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
	

}
