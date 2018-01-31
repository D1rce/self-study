package test;

public class feizhengshusort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arri = new int[] { 50, 2, 1, 9 };
		//double[] arrk = new double[arri.length];
		int[] arrk = new int[arri.length];
		int[] arrH = new int[arri.length];
		int iLen = 0;
		int iC = 0;
		for (int i = 0; i < arri.length; i++) {
			iLen = getlen(arri[i]);
			
			arrH[i] = (int) (arri[i] / Math.pow(10, iLen - 1));
			arrk[i] = iLen;

			System.err.println(arrk[i]);
			System.err.println(arrH[i]);
			iC += iLen;
		}
		//System.err.println(iC);
//		
//		for (int i = 0; i < arri.length; i++) {
//		
//			//System.err.println((int)Math.pow(10, arrk[i]+ iC) / (int)Math.pow(10, arrk[i]+ iC));
//			
//			System.err.println(arrH[i]);
//		}
//		
		
		
//		for (int i = 0; i < arrk.length - 1; i++) {// 外层循环控制排序趟数
//			for (int j = 0; j < arrk.length - 1 - i; j++) {// 内层循环控制每一趟排序多少次
//				if (arrk[j] > arrk[j + 1]) {
//					int temp = arrk[j];
//					arrk[j] = arrk[j + 1];
//					arrk[j + 1] = temp;
//				}
//			}
//		}
//
//		for (int num : arrk) {
//			System.err.println(num);
//		}

	}

	static int getlen(int intI) {
		int icount = 0;
		if (intI < 0) {
			return 1;
		} else {
			while (intI > 0) {
				intI = intI / 10;
				icount++;
			}
		}
		return icount;
	}

}
