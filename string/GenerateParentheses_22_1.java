package string;

import java.util.ArrayList;
import java.util.List;

/*
 * topic: string  backtracking(回溯)
 */

public class GenerateParentheses_22_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=generateParenthesis(3);
		System.out.println(list);
	}
	static List<String> generateParenthesis(int n) {
        	List<String> list=new ArrayList<String>();
        	StringBuilder strBuilder=new StringBuilder();
        	backtracking(list,strBuilder,0,0,n);
        	return list;
    }
	static void backtracking(List<String> list,StringBuilder strBuilder,int leftNum,int rightNum,int totalNum) {
		if(rightNum>leftNum) return;
		if(rightNum==totalNum&&leftNum==totalNum)
			list.add(strBuilder.toString());
		if(rightNum<totalNum) {
			strBuilder.append(')');
			rightNum++;
			backtracking(list,strBuilder,leftNum,rightNum,totalNum);
			strBuilder.deleteCharAt(strBuilder.length()-1);
			rightNum--;
		}
		if(leftNum<totalNum) {
			strBuilder.append('(');
			leftNum++;
			backtracking(list,strBuilder,leftNum,rightNum,totalNum);
			strBuilder.deleteCharAt(strBuilder.length()-1);
			rightNum--;
		}
		
	}
}
