package binarySearch;

public class FirstBadVersion_278_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	static class Solution {
	    public int firstBadVersion(int n) {
	        int hi=n;
	        int lo=1;
	        while(lo<=hi) {
	        	int mid=lo+(hi-lo)/2;
//	        	if(isBadVersion(mid))
//	        		hi=mid-1;
//	        	else
//	        		lo=mid+1;
	        }
	        return lo;		
	    }
	}
	

}
