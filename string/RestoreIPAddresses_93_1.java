package string;
//Given a string containing only digits, restore it by returning all possible valid IP address combinations.

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RestoreIPAddresses_93_1().restoreIpAddresses("25525511135"));
	}
	public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();
        int len=s.length();
        if(s==null||len>12||len<4)return ipList;
        for(int i=1;i<4&&i<len-2;i++) {
        	for(int j=i+1;j<i+4&&j<len-1;j++) {
        		for(int k=j+1;k<j+4&&k<len;k++) {
        			String s1=s.substring(0,i);
        			String s2=s.substring(i,j);
        			String s3=s.substring(j,k);
        			String s4=s.substring(k,len);
        			if(s4=="")System.out.println(k);
        			if(isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4)) ipList.add(s1+"."+s2+"."+s3+"."+s4);
        		}
        	}
        }
        return ipList;
    }
	static boolean isValid(String s) {
		
		if((s.charAt(0)=='0'&&s.length()>1)||Integer.parseInt(s)>255)return false;
        return true;
	}
}
