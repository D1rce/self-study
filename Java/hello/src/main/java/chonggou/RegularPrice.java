package chonggou;

public class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		// TODO �Զ����ɵķ������
		return Movie.REGULAR;
	}

	@Override
	double getCharge(int dayRented) {
		// TODO �Զ����ɵķ������
		double result = 2;
		if(dayRented > 2)
			result += (dayRented - 2) * 1.5;
		return result;
	}

}
