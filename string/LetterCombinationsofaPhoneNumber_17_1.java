package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=letterCombinations("7");
		System.out.println(list);
	}
	static List<String> letterCombinations(String digits) {
	        List<String> list=new ArrayList<>();
	        if(digits==null||digits.length()==0){
	            return list;
	        }
	        StringBuilder strBuilder=new StringBuilder();
	        backtracking(list,strBuilder,digits,0);
	        return list;
	}
	static void backtracking(List<String> list,StringBuilder strBuilder,String digits,int progress) {
		if(progress==digits.length()) {
			list.add(strBuilder.toString());
			return;
		}
		char temp=digits.charAt(progress);
		if(temp<'7') {                     //2-8
			char ch=(char) ('a'+3*(temp-'2'));
			for(int i=0;i<3;i++) {
				strBuilder.append(ch++);
				backtracking(list,strBuilder,digits,progress+1);
				strBuilder.deleteCharAt(strBuilder.length()-1);
			}
		}else if(temp=='7') {
			char ch='p';
			for(int i=0;i<4;i++) {
				strBuilder.append(ch++);
				backtracking(list,strBuilder,digits,progress+1);
				strBuilder.deleteCharAt(strBuilder.length()-1);
			}
		}else if(temp=='8') {
			char ch='t';
			for(int i=0;i<3;i++) {
				strBuilder.append(ch++);
				backtracking(list,strBuilder,digits,progress+1);
				strBuilder.deleteCharAt(strBuilder.length()-1);
			}
		}else {
			char ch='w';
			for(int i=0;i<4;i++) {
				strBuilder.append(ch++);
				backtracking(list,strBuilder,digits,progress+1);
				strBuilder.deleteCharAt(strBuilder.length()-1);
			}
		}
		
	}
}
