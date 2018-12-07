package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidAnagram_242_0().isAnagram2("ratsy","tsary"));
	}
	
	//排序 复杂度是O(nlgn)
	public boolean isAnagram(String s, String t) {
        if(s==null||t==null)return false;
        char[] ss=s.toCharArray();
        char[] ts=t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(ts);
		//==比较的是两个字符串的地址是否为相等（同一个地址），equals()方法比较的是两个字符串对象的内容是否相同
		if(toString().valueOf(ss).equals(toString().valueOf(ts))) {
			return true;
		}
		return false;
    }
	
	//beats 100%  算法复杂度是O(n)
	public boolean isAnagram1(String s, String t) {
		int[] recordTable =new int['z'-'a'+1];
		if(s==null||t==null)return false;
		
		char[] ss=s.toCharArray();
		char[] ts=t.toCharArray();
		for(char c:ss) {
			recordTable[c-'a']++;
		}
		for(char c:ts) {
			recordTable[c-'a']--;
		}
		for(int i:recordTable) {
			if(i!=0)return false;
		}
		return true;
	}
	//针对题目中的follow up
	//Follow up:
	//What if the inputs contain unicode characters? How would you adapt your solution to such case?
	
	/*
	 * java 在内存中存储字符是用 UTF16编码方式 一个char占两个字节，一个字符会占用2个或4个字节（有些字符用两个char表示）
	 */
	public boolean isAnagram2(String s, String t) {
		if(s==null||t==null)return false;
		int slen=s.length();
		int tlen=t.length();
		if(slen!=tlen)return false;
		
		Map<Integer,Integer> hashmap=new HashMap<>();
		int index=0;
		while(index<slen) {
			int codepoint=s.codePointAt(index);
			hashmap.put(codepoint, hashmap.getOrDefault(codepoint,0)+1);
			index+=Character.charCount(codepoint);  //返回表示当前的字符需要的字节数
		}
		//压缩代码
		//s.codePoints().forEach(codePoint -> hashmap.put(codepoint, hashmap.getOrDefault(codepoint,0)+1)); lambda表达式
		
		index=0;
		while(index<tlen) {
			int codepoint=t.codePointAt(index);
			int count=hashmap.getOrDefault(codepoint, 0);
			if(count==0)return false;
			else
				hashmap.put(codepoint, count-1);
			index+=Character.charCount(codepoint);
		}
		return true;
		
	}
}

	

