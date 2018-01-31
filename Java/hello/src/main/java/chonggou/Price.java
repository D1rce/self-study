package chonggou;

public abstract class Price {
	abstract int getPriceCode();
	abstract double getCharge(int dayRented);
	
	int getFrequentRenterPoints(int dayRented){
		return 1;
	}
}
