package chonggou;

public class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		// TODO �Զ����ɵķ������
		return Movie.NEW_RELEASE;
	}

	@Override
	double getCharge(int dayRented) {
		// TODO �Զ����ɵķ������
		return dayRented * 3;
	}
	@Override
	int getFrequentRenterPoints(int dayRented){
		return (dayRented > 1) ? 2 : 1;
	}
	
}
