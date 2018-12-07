package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Could you optimize your algorithm to use only O(k) extra space?
public class PascalsTriangleII_119_0 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result1;
		result1=getRow2(32);
		System.out.println(Arrays.toString(result1.toArray()));
		
//		List<Integer> list = new ArrayList<Integer>();
//		System.out.println(list.size());
//		System.out.println(Arrays.toString(list.toArray()));
//		list.add(0,1);
//		System.out.println(list.size());
//		System.out.println(Arrays.toString(list.toArray()));
//		list.add(0,1);
//		System.out.println(list.size());
//		System.out.println(Arrays.toString(list.toArray()));
//		list.add(0,1);
//		System.out.println(list.size());
//		System.out.println(Arrays.toString(list.toArray()));
//		list.add(1,3);
//		System.out.println(list.size());
//		System.out.println(Arrays.toString(list.toArray()));
//		list.add(1,3);
//		System.out.println(list.size());
//		System.out.println(Arrays.toString(list.toArray()));
		
	}

    static public List<Integer> getRow(int rowIndex) {
        List<Integer> result =new ArrayList<Integer>(rowIndex);
        //System.out.println(result.size());
        for(int i=0;i<=rowIndex/2;i++) {
        	result.add(i,getValue(rowIndex,i));
        }
        for(int i=rowIndex/2+1;i<=rowIndex;i++) {
        	result.add(i,result.get(rowIndex-i));
        }
        //System.out.println(result.size());
        return result;
    }
    
    //直接递归 会导致重复计算 程序超时
	static int getValue(int i,int j) {                          
		//System.out.println(i+"  "+j);
		if(j>i) {
			return 0;
		}
		if(j==0){
			return 1;
		}
		return getValue(i-1,j-1)+getValue(i-1,j);
	}
	
	//普通的按照 每一行遍历 beats 89%,但是这样没有办法做到O(k) space
	static public List<Integer> getRow1(int rowIndex){  
		Integer[] upList = {1};
		Integer[] downList= {1};
		int j=0;
		for(int i=0;i!=rowIndex;i++) {
			downList=new Integer[i+2];
			for(j=1;j<i+1;j++) {
				downList[j]=upList[j-1]+upList[j];
			}
			downList[0]=1;
			downList[i+1]=1;
			upList=downList;
		}
		return Arrays.asList(upList);
	}
	
	//O(K) space解法
	static public List<Integer> getRow2(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>(rowIndex+1);
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
    }
}
