package string;

public class LongestPalindromicSubstring_5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring_5_1().longestPalindrome2("abcba"));
	}
	
	//自己的初步的解法
	public String longestPalindrome(String s) {
        if(s==null||s.length()==0)return "";
		//String sReverse=new StringBuilder(s).reverse().toString();
        int len=s.length();
        int currMax=0; //当前最大的回文字符串长度
        int j=0;
        int begin=0,end=0;
        
        for(int i=0;i<len-1;i++) {
        	j=i;
        	//先判断偶数字符个数的字符串
        	while(j>=0&&2*i+1-j<len) {
        		if(s.charAt(j)!=s.charAt(2*i+1-j)) {
        			break;
        		}
        		j--;
        	}
        	if(2*(i-j)>currMax) {
        		begin=j+1;
            	end=2*i+1-(j+1);
            	currMax=2*(i-j);
        	}
        	//再判断奇数字符个数的字符串
        	j=i-1;
        	while(j>=0&&2*i-j<len) {
        		if(s.charAt(j)!=s.charAt(2*i-j)) {
        			break;
        		}
        		j--;
        	}
        	if(2*(i-j)-1>currMax) {
        		begin=j+1;
            	end=2*i-(j+1);
            	currMax=2*(i-j)-1;
        	}
        }
        if(currMax>0) {
        	return s.substring(begin, end+1);
        }else
        	return s.substring(0,1);
    }
	
	private int currMax;
	private int lo;
	
	//改进初步的解法，压缩代码量,执行最快
	public String longestPalindrome1(String s) {
		int len=s.length();
		if(s==null)return "";
		if(len<2)return s;
		
		currMax=0; //当前最大的回文字符串长度
	    
	    for(int i=0;i<len-1;i++) {
	    	checkPalindrome(s,i,i);
	    	checkPalindrome(s,i, i+1);
	    }
		return s.substring(lo, lo+currMax);
	}
	private void checkPalindrome(String s,int begin, int end) {
		while(begin>=0&&end<s.length()&&s.charAt(begin)==s.charAt(end)) {
			begin--;
			end++;
		}
		if(currMax<(end-1-begin-1+1)) {
			currMax=end-begin-1;
			lo=begin+1;
		}
	}
	
	//leetcode-动态规划的解法
	public String longestPalindrome2(String s) {
		int len=s.length();
		if(s==null)return "";
		if(len<2)return s;
		
		currMax=0; //当前最大的回文字符串长度
		boolean[][] isPalindrome =new boolean[len][len];
		
		for(int i=len-1;i>=0;i--) {
			for(int j=i;j<len;j++) {
				if(s.charAt(i)==s.charAt(j)&&(j-i<3||isPalindrome[i+1][j-1]))isPalindrome[i][j]=true;
				if(isPalindrome[i][j]) {
					if(j-i+1>currMax) {
						lo=i;
						currMax=j-i+1;
						System.out.println(lo+"   "+currMax);
					}
				}
			}
		}
		System.out.println(lo+"   "+currMax);
		return s.substring(lo, lo+currMax);
		
	}
	
	//related Question: 214. Shortest Palindrome Hard
}
