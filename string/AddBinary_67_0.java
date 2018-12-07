package string;

public class AddBinary_67_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11","1"));
	}
	
	/*
	 * 标准库 操作; 这种方法有问题 当字符串很长时  转化成int超过范围
	 * Integer大小范围 -2^31~2^31-1 跟int的取值范围一样
	 */
	static String addBinary1(String a, String b) {
        Integer inta,intb;
        inta=Integer.parseInt(a,2);
        intb=Integer.parseInt(b,2);
        return Integer.toBinaryString(inta+intb);   
    }
	
	
	/*
	 * 不进行转化 完全按照字符串 按位操作
	 */
	static String addBinary(String a,String b) {
		int lena=a.length();
		int lenb=b.length();
		boolean hasCarry=false;
		int i;
		StringBuilder strBuilder;
		if(lena>=lenb) {
			strBuilder=new StringBuilder(a);
			for(i=1;i<=lenb;i++) {
				if(strBuilder.charAt(lena-i)!=b.charAt(lenb-i)) {
					if(hasCarry) {
						strBuilder.setCharAt(lena-i, '0');
					}else {
						strBuilder.setCharAt(lena-i, '1');
						hasCarry=false;
					}
				}else if(strBuilder.charAt(lena-i)=='0'){
					if(hasCarry) {
						strBuilder.setCharAt(lena-i, '1');
						hasCarry=false;
					}else {
						strBuilder.setCharAt(lena-i, '0');
					}
				}else {
					if(hasCarry) {
						strBuilder.setCharAt(lena-i, '1');
					}else {
						strBuilder.setCharAt(lena-i, '0');
						hasCarry=true;
					}
				}
			}
		
			while(i<=lena) {
				if(hasCarry) {
					if(strBuilder.charAt(lena-i)=='0') {
						strBuilder.setCharAt(lena-i, '1');
						hasCarry=false;
					}else {
						strBuilder.setCharAt(lena-i, '0');
					}
				}else {
					break;
				}
				i++;
			}
			
			
		}else {
			strBuilder=new StringBuilder(b);
			for(i=1;i<=lena;i++) {
				if(strBuilder.charAt(lenb-i)!=a.charAt(lena-i)) {
					if(hasCarry) {
						strBuilder.setCharAt(lenb-i, '0');
					}else {
						strBuilder.setCharAt(lenb-i, '1');
						hasCarry=false;
					}
				}else if(strBuilder.charAt(lenb-i)=='0'){
					if(hasCarry) {
						strBuilder.setCharAt(lenb-i, '1');
						hasCarry=false;
					}else {
						strBuilder.setCharAt(lenb-i, '0');
					}
				}else {
					if(hasCarry) {
						strBuilder.setCharAt(lenb-i, '1');
					}else {
						strBuilder.setCharAt(lenb-i, '0');
						hasCarry=true;
					}
				}
			}
			while(i<=lenb) {
				if(hasCarry) {
					if(strBuilder.charAt(lenb-i)=='0') {
						strBuilder.setCharAt(lenb-i, '1');
						hasCarry=false;
					}else {
						strBuilder.setCharAt(lenb-i, '0');
						
					}
				}else {
					break;
				}
				i++;
			}
		}
		if(hasCarry) {
			return '1'+strBuilder.toString();
		}else
			return strBuilder.toString();
	}
}
