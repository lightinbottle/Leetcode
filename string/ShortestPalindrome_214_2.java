package string;

/*
 * description：     字符串之前加字符 构成最短的回文字符串  KMP
 * similar Question: LongestPalindromicSubstring（5）
 */
public class ShortestPalindrome_214_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ShortestPalindrome_214_2().shortestPalindrome("abcd"));
	}
	public String shortestPalindrome(String s) {
        int len=s.length();
        if(len<2||s==null)return s;
		if(isPalindrome(s))return s;
        
		StringBuilder strBuilder=new StringBuilder(s);
		for(int i=len/2-1;i>=0;i--) {
			if(shortestPalindrome(strBuilder,i,i+1))break;    //i,i+1  为中间的元素
			if(shortestPalindrome(strBuilder,i,i))break;      //i为中间的元素
		}
		return strBuilder.toString();
    }
	
	private static boolean shortestPalindrome(StringBuilder strBuilder,int begin,int end) {
		int len=strBuilder.length();
		while(begin>=0&&end<len) {
			if(strBuilder.charAt(begin)!=strBuilder.charAt(end))return false;
			begin--;
			end++;
		}
		while(end<len) {
			strBuilder.insert(0, strBuilder.charAt(end));
			end+=2;
			len++;
		}
		return true;
	}
	private static boolean isPalindrome(String s) {
		int i=0,j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))return false;
			i++;
			j--;
		}
		return true;
	}
	
	/*
	 * 1. recursive Java solution https://leetcode.com/problems/shortest-palindrome/discuss/60098/My-7-lines-recursive-Java-solution
	 * 2. KMP solution 
	 */
}
