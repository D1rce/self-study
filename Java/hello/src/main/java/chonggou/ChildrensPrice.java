package chonggou;

public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		// TODO �Զ����ɵķ������
		return Movie.CHILDRENS;
	}

	@Override
	double getCharge(int dayRented) {
		// TODO �Զ����ɵķ������
		double result = 1.5;
		if(dayRented > 3)
			result = (dayRented - 3) * 1.5;
		return result;
	}
}
