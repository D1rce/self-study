package test;

public class feibo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int inti = 0;
		int intj = inti + 1;
		int[] arri = new int[20];
		arri[inti] = inti;
		arri[intj] = intj;
		
		for(int j = 1;j < arri.length;j++){
			if(inti + intj +j >= arri.length){
				break;
			}
			arri[inti + intj +j] = arri[inti  + j -1] + arri[ intj + j -1];
		}
		
		
		for(int a:arri){
			System.err.println(" feibo ->" + a);
		}
		
	}
}
