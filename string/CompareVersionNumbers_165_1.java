package string;

import java.util.Arrays;

public class CompareVersionNumbers_165_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CompareVersionNumbers_165_1().compareVersion("7.0.0","7.0"));
	}
	public int compareVersion(String version1, String version2) {
        String[] version1s=version1.split("\\.");   //* ^ : | . \ 需要转译， 多个分隔符借助 借助 | 符号
        String[] version2s=version2.split("\\.");
        //System.out.println(Arrays.toString(version1s));
      // System.out.println(Arrays.toString(version2s));
        
        int len=Math.max(version1s.length, version2s.length);
        
        int int1,int2;
        for(int i=0;i<len;i++) {
        	int1=i<version1s.length?Integer.parseInt(version1s[i]):0;    //减少对数组的访问
        	int2=i<version2s.length?Integer.parseInt(version2s[i]):0;
        	if(int1<int2)return -1;
        	if(int1>int2)return 1;
        }
        
        return 0;
    }

}
