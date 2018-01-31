package test;

public class GetSum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arri = new int[]{0,2,3,10,20};
		System.err.println(getForSum(arri));
		System.err.println(getWhileSum(arri));
		System.err.println(getRecursionSum(arri,0,0));
		
		
		
		
		
		
		
	}
	
	
	static int getForSum(int[] arri){
		int isum = 0;
		for(int i:arri){
			isum += i;
		}
		return isum;
	}
	
	static int getWhileSum(int[] arri){
		int isum = 0;
		int ilen = 0;
		while(ilen < arri.length){
			isum += arri[ilen];
			ilen ++;
		}
		return isum;
	}
	static int getRecursionSum(int[] arri,int i,int isum){
		
		if(arri.length <= i){
			return isum;
		}else{
			isum += arri[i];
			i++;
			isum = getRecursionSum(arri,i,isum);
		}
		return isum;
	}
}
