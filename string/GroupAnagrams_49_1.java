package string;
/*
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * anagrams string字符串定义： 由相同的字符组合产生的字符串
 */
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams_49_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new GroupAnagrams_49_1().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println(new GroupAnagrams_49_1().groupAnagrams(new String[] {"eat","eat", "tea", "tan", "ate", "nat", "bat"}));
	    //结果不用去重
	}
	public List<List<String>> groupAnagrams(String[] strs) {
        int len=strs.length;
        if(strs==null||len==0)return new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        char[] temp;
        for(String str:strs) {
        	
        	temp=str.toCharArray();
        	Arrays.sort(temp);
        	String keyStr=String.valueOf(temp);                  //这里不是用 temp.toString() 这个方法是把这个对象转化为字符串
        	System.out.println(str+"   "+keyStr);
        	if(map.containsKey(keyStr)) {
        		map.get(keyStr).add(str);
        	}else {
        		map.put(keyStr, new ArrayList<String>());
        		map.get(keyStr).add(str);
        	}
        }
        return new ArrayList<List<String>>(map.values());
    }
	//另一种解法 https://leetcode.com/problems/group-anagrams/discuss/19183/Java-beat-100!!!-use-prime-number


}
