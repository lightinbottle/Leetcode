package string;

public class LengthofLastWord_58_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("Hello World 12"));
	}
	static int lengthOfLastWord(String s) {
        if(s==null){
        	return 0;
        }
        
        char currChar;
        int count=0;
        boolean hasWord=false;
        for(int i=s.length()-1;i>=0;i--) {
        	currChar=s.charAt(i);
        	if((currChar<='Z'&&currChar>='A')||(currChar<='z'&&currChar>='a')) {
        		if(hasWord){
        			count++;
        		}else {
        			hasWord=true;
        			count=1;
        		}
        	}else {
        		if(hasWord) {
        			break;
        		}
        	}
        }
        return count;
    }
}
