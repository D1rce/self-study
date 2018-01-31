package chonggou;

public class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		// TODO 自动生成的方法存根
		return Movie.REGULAR;
	}

	@Override
	double getCharge(int dayRented) {
		// TODO 自动生成的方法存根
		double result = 2;
		if(dayRented > 2)
			result += (dayRented - 2) * 1.5;
		return result;
	}

}
