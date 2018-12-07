package string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath_71_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SimplifyPath_71_1().simplifyPath1("/a//b////c/d//././/.."));
	}
	//path = "/a//b////c/d//././/..", => "/a/b/c"
	public String simplifyPath(String path) {
        String result="";
        if(path.length()==0)return result;
		Stack<String> stack=new Stack<>();
		//System.out.println(Arrays.toString(path.split("/")));
        for(String s:path.split("/")) {
        	if(s.equals(""))continue;
        	if(s.equals("."))continue;
        	if(s.equals("..")) {
        		if(!stack.isEmpty())stack.pop();
        		continue;
        	}
        	stack.push(s);
        }
        while(!stack.isEmpty())result="/"+stack.pop()+result;
        if(result.length()==0)result="/";      //path="/"
        return result;
    }
	
    //优化程序的执行效率
	public String simplifyPath1(String path) {
        String result="";
        if(path.length()==0)return result;
		LinkedList<String> stack=new LinkedList<>();    //用LinkedList来代替Stack
		//System.out.println(Arrays.toString(path.split("/")));
        for(String s:path.split("/")) {
        	if(s.equals(""))continue;
        	if(s.equals("."))continue;
        	if(s.equals("..")) {
        		if(!stack.isEmpty())stack.pop();
        		continue;
        	}
        	stack.push(s);
        }
        while(!stack.isEmpty())result="/"+stack.pop()+result;
        if(result.length()==0)result="/";      //path="/"
//        StringBuilder strBuilder=new StringBuilder();
//        while(!stack.isEmpty()) {
//        	strBuilder.append("/");
//        	strBuilder.append(stack.pop());
//        	//strBuilder.insert(offset, str)
//        }
        
        return result;
    }
}
