package string;
//寻找 字符串数组所有元素的 公有的最长前缀
public class LongestCommonPrefix_14_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//这个算法复杂度是O(N*M)  N=strs.length  M=strs[0].length
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0)return "";                           //特殊输入要注意
        StringBuilder strBuilder=new StringBuilder();
        int index=0;
        char ch;
        while(true) {
        	if(index<strs[0].length()) {
        		ch=strs[0].charAt(index);
        	}else {
        		return strBuilder.toString();
        	}
        	for(int i=1;i<strs.length;i++) {
        		if(index>=strs[i].length()) {
        			return strBuilder.toString();
        		}
        		if(strs[i].charAt(index)!=ch) {
        			return strBuilder.toString();
        		}
        	}
        	strBuilder.append(ch);
        	index++;
        }
    }
	
	//最佳实现 算法复杂度O(N)
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null)       return null;
        if (strs.length == 0)   return "";
        
        String first = strs[0], last = strs[0];
        
        for (String str : strs) {
            if (str.compareTo(first) < 0)
                first = str;
            if (str.compareTo(last) > 0)
                last = str;
        }
        
        int i = 0, len = Math.min(first.length(), last.length());
        
        while (i < len && first.charAt(i) == last.charAt(i))
            i++;
        
        return first.substring(0, i);
    
    }
}
