package string;

public class StringtoInteger_8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringtoInteger_8_1().myAtoi("-21474836480"));
		int a=Integer.MIN_VALUE;
		a-=1;
		System.out.println(Integer.parseInt("sdf"));           //官方的方法 
	}
	
	//这一题其实可以通过一个 double来存储 判断是否大于 Integer.MAX_VALUE 小于Integer.MIN_VALUE
	public int myAtoi(String str) {
        //return Integer.parseInt(str);           //官方的方法 如果溢出就会报错
		//return Integer.valueOf(str).intValue();
		int len=str.length();
		if(str==null||len==0)return 0;
		int index=0;
		int result=0;
		boolean isPositive=true;
		int limit=-Integer.MAX_VALUE;
		
		while(index<len&&str.charAt(index)==' ')index++;
		if(index==len)return 0;
		if(str.charAt(index)=='+')index++;
		if(str.charAt(index)=='-') {index++;isPositive=false;limit=Integer.MIN_VALUE;}
		
		System.out.println(index);
		for(int i=index;i<len&&str.charAt(i)>='0'&&str.charAt(i)<='9';i++){
			if(isPositive) {
				result=result*10+(str.charAt(i)-'0');
				if(result<0)return Integer.MAX_VALUE;
			}else{
				result=result*10-(str.charAt(i)-'0');
				if(result>=0)return Integer.MIN_VALUE;
			}
			System.out.println(result);
		}
		return result;
    }
}
