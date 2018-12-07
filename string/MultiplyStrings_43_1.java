package string;

import java.util.Arrays;

public class MultiplyStrings_43_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MultiplyStrings_43_1().multiply1("0","456"));
	}
	//返回 num1*num2
	//The length of both num1 and num2 is < 110   int(num1)<10^111
	//You must not use any built-in BigInteger library or convert the inputs to integer directly.
	//faster than 68.16% of Java 
	public String multiply(String num1, String num2) {
		int num1len=num1.length();
		int num2len=num2.length();
		int[] num1list=new int[num1len];
		int[] num2list=new int[num2len];
		int[] result=new int[num1len+num2len];
		for(int i=num1len-1;i>=0;i--)num1list[num1len-1-i]=num1.charAt(i)-'0';
		for(int i=num2len-1;i>=0;i--)num2list[num2len-1-i]=num2.charAt(i)-'0';
		int carry=0;
		System.out.println(result[0]);
		for(int i=0;i<num1len;i++) {
			int k=i;
			for(int j=0;j<num2len;j++) {
				int temp=num1list[i]*num2list[j]+carry+result[k];
				result[k]=temp%10;
				carry=temp/10;
				k++;
			}
			if(carry>0) {result[k]=carry;}
			carry=0;
		}
		StringBuilder strBuilder=new StringBuilder(num1len+num2len);
		int k=result.length-1;
		while(k>=0&&result[k]==0)k--;
		if(k<0)return "0";
		for(int i=k;i>=0;i--)
			strBuilder.append((char)('0'+result[i]));

		return strBuilder.toString();
	}
	
	//改进 减少多余空间的使用
	public String multiply1(String num1, String num2) {
		int num1len=num1.length();
		int num2len=num2.length();
		int[] result=new int[num1len+num2len];
	
		for(int i=num1len-1;i>=0;i--) {
			int k=result.length-(num1len-i);
			for(int j=num2len-1;j>=0;j--) {
				int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+result[k];
				result[k]=temp%10;
				result[k-1]+=temp/10;
				k--;
			}
		}
		StringBuilder strBuilder=new StringBuilder(num1len+num2len);    //尽量减少 附加变量的使用
		for(int i=0;i<result.length;i++) {
			if(result[i]==0)continue;
			strBuilder.append((char)('0'+result[i]));
		}

		return strBuilder.length()==0?"0":strBuilder.toString();
	}
}
