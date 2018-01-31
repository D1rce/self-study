package chonggou;

public class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		// TODO 自动生成的方法存根
		return Movie.NEW_RELEASE;
	}

	@Override
	double getCharge(int dayRented) {
		// TODO 自动生成的方法存根
		return dayRented * 3;
	}
	@Override
	int getFrequentRenterPoints(int dayRented){
		return (dayRented > 1) ? 2 : 1;
	}
	
}
