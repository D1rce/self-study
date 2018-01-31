package test;

import java.util.ArrayList;
import java.util.List;

public class ListMerging {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List list1 = new ArrayList();
		list1.add('a');
		list1.add('B');
		list1.add('C');
		list1.add('D');
		list1.add('E');
		
		List list2 = new ArrayList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(2.2);
		listMerger(list1,list2);
	}
	
	static void listMerger(List list1 ,List list2 ) 
	{
		int iCount = list1.size()+list2.size();
		int j =0;
		int k = 0;
		Object[] arri = new Object [iCount];
		for(int i =0;i < iCount;i++){
			if(i % 2 == 0 && j < list1.size()){
				arri[i]= list1.get(j++);
			}else if(k < list2.size()){
				arri[i]= list2.get(k++);
			}
		}
		for(Object a:arri){
			System.err.println(a.toString());
		}
	}
	
}
