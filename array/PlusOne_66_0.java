package array;
import java.util.Arrays;
public class PlusOne_66_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {9,9,9,9,9};
		System.out.println(Arrays.toString(plusOne(a)));
	}
	static public int[] plusOne(int[] digits) {
        //if(digits[digits.length-1])
		//digits[0]=99;
		int i=digits.length-1;
		while(i>=0) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;            //O(N)
			}
			digits[i]=0;
			i--;
		}
		int[] b=new int[digits.length+1];
		b[0]=1;
		for(i=1;i<b.length;i++) {
			b[i]=0;
		}
		return b;
    }

}
