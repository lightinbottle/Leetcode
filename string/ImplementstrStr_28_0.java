package string;

/*
 * description：     返回子串出现的第一个位置 如果不存在返回 -1  如果needle为空字符串 则返回 0
 * similar Question: Shortest Palindrome(214) LongestPalindromicSubstring(5)
 */

public class ImplementstrStr_28_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ImplementstrStr_28_0().strStr("hello", "ll"));
	}
	public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if(haystack==null||needle==null)return -1;
        if(len2==0)return 0;
        if(len1<len2)return -1;
        
        int i=0,j=0;
        boolean hasPre=false;
        for(int k=0;k<=len1-len2;k++) {
        	if(haystack.charAt(k)!=needle.charAt(0))continue;       // if(haystack.substring(i,i+n).equals(needle)) 直接调用库函数
        	int m=1;
        	for(;m<len2;m++)
        		if(needle.charAt(m)!=haystack.charAt(k+m))break;
        	if(m==len2)return k;
        }
        return -1;
    }
}
