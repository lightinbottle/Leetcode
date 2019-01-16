package binarySearch;

public class Searcha2DMatrix_74_1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[][]={{1,2,3},{4,5,6}};
		System.out.println(new Searcha2DMatrix_74_1().searchMatrix(a, 7));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null)return false;
		//两个二分搜索查找
		int M=matrix.length;
        if(M==0)return false;
		int N=matrix[0].length;
        if(N==0)return false;
		
		//第一个二分搜索
		int hi=M-1;
		int lo=0;
		int mid;
		while(lo<=hi) {
			mid=lo+(hi-lo)/2;
			if(matrix[mid][0]>target)
				hi=mid-1;
			else if(matrix[mid][0]<target)
				lo=mid+1;
			else
				return true;
		}
		if(lo<=0)return false;
		if(matrix[lo-1][N-1]<target)return false;
		
		//第二个二分搜索
		int targetRow=lo-1;      //目标行
		hi=N-1;
		lo=0;
		while(lo<=hi) {
			mid=lo+(hi-lo)/2;
			if(matrix[targetRow][mid]>target)
				hi=mid-1;
			else if(matrix[targetRow][mid]<target)
				lo=mid+1;
			else
				return true;
		}
		return false;		
    }
}
