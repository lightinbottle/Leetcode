package string;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger_13_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RomantoInteger_13_0().romanToInt1("MCMXCIV"));
	}
	public int romanToInt(String s) {
	       
        Map<Character,Integer> map=new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result=0;
        
        int curr=0;
        int next=0;
        for(int i=0;i<s.length()-1;i++) {
        	curr=map.get(s.charAt(i));
        	next=map.get(s.charAt(i+1));
        	
        	if(curr<next){
        		result-=curr;
        	}else {
        		result+=curr;
        	}
        }
        return result+=map.get(s.charAt(s.length()-1));
    }
	
	//HashMap 操作太耗时了
	
	public int romanToInt1(String s) {
	    int nums[]=new int[s.length()];
	    for(int i=0;i<s.length();i++){
	        switch (s.charAt(i)){
	            case 'M':
	                nums[i]=1000;
	                break;
	            case 'D':
	                nums[i]=500;
	                break;
	            case 'C':
	                nums[i]=100;
	                break;
	            case 'L':
	                nums[i]=50;
	                break;
	            case 'X' :
	                nums[i]=10;
	                break;
	            case 'V':
	                nums[i]=5;
	                break;
	            case 'I':
	                nums[i]=1;
	                break;
	        }
	    }
	    int sum=0;
	    for(int i=0;i<nums.length-1;i++){
	        if(nums[i]<nums[i+1])
	            sum-=nums[i];
	        else
	            sum+=nums[i];
	    }
	    return sum+nums[nums.length-1];
	}
	
}
