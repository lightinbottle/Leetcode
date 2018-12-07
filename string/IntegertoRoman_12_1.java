package string;

public class IntegertoRoman_12_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IntegertoRoman_12_1().intToRoman1(1994));
	}
	public String intToRoman(int num) {
        
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
        
    }
	
	public String intToRoman1(int num) {
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    StringBuilder strBuilder=new StringBuilder();
	    
	    for(int i=0;i<values.length;i++) {
	    	while(num>=values[i]) {
	    		num-=values[i];
	    		strBuilder.append(strs[i]);
	    	}
	    }
	    return strBuilder.toString();
	    
	}
	
}
