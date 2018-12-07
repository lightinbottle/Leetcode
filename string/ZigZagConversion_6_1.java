package string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion_6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion_6_1().convert("PAYPALISHIRING",4));
	}
	
	
	//朴素的做法
	public String convert(String s, int numRows) {
        
		int len=s.length();
		if(s==null)return "";
        if(len<2||numRows==1) return s;
		
		StringBuilder[] table=new StringBuilder[numRows];
		for(int i=0;i<numRows;i++)table[i]=new StringBuilder();
		
        int insertIndex=0;
        boolean down=true;
        String result="";
        
        for(int i=0;i<len;i++) {
        	table[insertIndex].append(s.charAt(i));
        	if(insertIndex==numRows-1) down=false;
        	if(insertIndex==0)         down=true;
        	insertIndex+=down?1:-1;
        }
        for(int i=1;i<numRows;i++) {
        	table[0].append(table[i]);
        }
        return table[0].toString();
    }
}
