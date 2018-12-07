package array;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */

public class BestTimetoBuyandSellStock_121_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {7,6,4,3,1};
		System.out.println(maxProfit(a));

	}
	static public int maxProfit(int[] prices) {
		if(prices.length==0) {                        //注意边界条件
			return 0;
		}
        int endindex=prices.length%2;
        int result=0;
        int max=prices[prices.length-1];
        int i,j;
        for(i=prices.length-1;i>=endindex;i--) {
        	if(prices[i]<max)
        		continue;
        	for(j=i-1;j>=0;j--) {
        		if((prices[i]-prices[j])>result) {
        			result=prices[i]-prices[j];
        		}
        	}
        
        }
        if(result<=0)
        	return 0;
        else
        	return result;
    }
	
	//O(N)算法复杂度的算法
	static public int maxProfit1(int[] prices) {
		if (prices.length == 0) {
			 return 0 ;
		 }
		int minPrice=prices[0];
		int result=0;
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<minPrice) {
				minPrice=prices[i];
				continue;
			}
			if((prices[i]-minPrice)>result) {
				result=prices[i]-minPrice;
			}
		}
		return result;
	}
	
	//O(N)的算法； 这一题可以转化成求：最大的子串和
	//例如原始输入为[1, 7, 4, 11],相邻的股票价格作差，就可以转化为求[6,-3,7]的最大的子串和
	//利用Kadane 算法求最大子串
	static public int maxProfit2(int[] prices) {
		
		int soFarMax=0;
		int max=0;
		for(int j=1;j<prices.length;j++) {
			System.out.println(max+=prices[j]-prices[j-1]);
			max=Math.max(0, max+=prices[j]-prices[j-1]);                 //max一定是大于等于0的
			soFarMax=Math.max(soFarMax, max);
		}
		return soFarMax;
	}

}
