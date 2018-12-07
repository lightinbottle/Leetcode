package string;

public class ValidPalindrome_125_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	//时间复杂度O(2N) 空间复杂度O(N)
	static boolean isPalindrome(String s) {
		int len =s.length();
		if(len==0) 
			return true;
		StringBuilder strBuilder=new StringBuilder(len);
		char temp;
		
		for(int i=0;i<len;i++) {
			temp=s.charAt(i);
			if(temp>='A'&&temp<='Z') {
				//strBuilder.setCharAt(strBuilderLen++, (char) (temp+32));
				strBuilder.append((char) (temp+32));
			}
			if((temp>='0'&&temp<='9')||(temp>='a'&&temp<='z')) {
				//strBuilder.setCharAt(strBuilderLen++, temp);
				strBuilder.append(temp);
			}
		}
		int left=0,right=strBuilder.length()-1;
		System.out.println(strBuilder);
		while(left<right) {
			if(strBuilder.charAt(left++)!=strBuilder.charAt(right--)) {
				return false;
			}
		}
		return true;
    }
	
	//three line java solution
	static boolean isPalindrome1(String s) {
		String actual=s.replace("[^A-Za-z0-9]", "").toString();    //oldChar 正则表达式
																//[^指定字符串] 指的是除指定字符串以外的其他字符串
		String reverse=new StringBuilder(actual).reverse().toString(); //字符串翻转的最快的方式
		return actual.equals(reverse);
		
	}
	
	//JAVA 中 char占两个字节
	public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
