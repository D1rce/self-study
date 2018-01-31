package chonggou;

public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		// TODO 自动生成的方法存根
		return Movie.CHILDRENS;
	}

	@Override
	double getCharge(int dayRented) {
		// TODO 自动生成的方法存根
		double result = 1.5;
		if(dayRented > 3)
			result = (dayRented - 3) * 1.5;
		return result;
	}
}
