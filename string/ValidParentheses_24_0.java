package string;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * topic: stack
 * similar Questions: 22
 */

public class ValidParentheses_24_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("){"));
	}
	static boolean isValid(String s) {
        if(s==null) {
        	return true;
        }
        if(s.length()%2==1) {
        	return false;
        }
        Stack<Character> stack=new Stack<Character>();
        char temp;
        for(int i=0;i<s.length();i++) {
        	temp=s.charAt(i);
        	if(temp=='{'||temp=='('||temp=='[') {
        		stack.push(temp);
        	}else {
        		if(stack.isEmpty())return false;                    //注意 如果stack为空  stack.isEmpty() 会报错
        		switch(temp) {
        		case '}':
        			if(stack.pop()!='{')
        				return false;
        			break;
        		case ']':
        			if(stack.pop()!='[')
        				return false;
        			break;
        		case ')':
        			if(stack.pop()!='(')
        				return false;
        			break;
        		}
        	}
        }
        return stack.isEmpty();   
    }
}
