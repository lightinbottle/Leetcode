package string;

/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221

 */

public class CountandSay_38_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay1(10));
	}
	static String countAndSay(int n) {
        String first="1";
        if(n==1) {
        	return first;
        }
        String next="";
        int count=1;
        char currChar;
        
        for(int i=1;i<n;i++) {
        	for(int j=0;j<first.length();j++) {
        		currChar=first.charAt(j);
        		while(j+1<first.length()) {
        			if(first.charAt(j+1)==currChar) {
        				j++;
        				count++;
        			}else {
        				break;
        			}
        		}
        		next+=(Integer.toString(count)+first.charAt(j));
        		count=1;
        	}
        	System.out.println(next);
        	first=next;
        	next="";
        	
        }
        return first;
    }
	
	/*
	 * 直接使用String 会导致效率很低
	 * 在性能方面 StringBuilder>StringBuffer>>String
	 * StringBuffer和StringBUilder的实现一样 StringBuilder是线程不安全的  StringBuffer是线程安全的
	 */
	static String countAndSay1(int n) {
		StringBuilder first=new StringBuilder("1");
       
        StringBuilder stringBuilder;
        int count=1;
        char currChar;
        
        for(int i=1;i<n;i++) {
        	//System.out.println(first);
        	currChar=first.charAt(0);
        	stringBuilder=new StringBuilder();
        	count=1;
        	
        	for(int j=1;j<first.length();j++){
        		if(first.charAt(j)!=currChar) {
        			stringBuilder.append(count).append(currChar);  //自动转化为字符串
        			currChar=first.charAt(j);
        			count=1;
        		}else {
        			count++;
        		}
        	}
        	stringBuilder.append(count).append(currChar);       //这一句不能忘
        	first=stringBuilder;
        }
        return first.toString();
	}
}
