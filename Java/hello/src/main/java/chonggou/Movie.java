package chonggou;

public class Movie {
	
	public final static int CHILDRENS = 0;
	public final static int REGULAR = 1;
	public final static int NEW_RELEASE = 2;
	
	private Price _price;

	private String _title;
	
	public int getPriceCode() {
		return _price.getPriceCode();
	}
	public String getTitle() {
		return _title;
	}

	//����ӰƬ����
	public void setPriceCode(int arg) {
		switch(arg){
			case CHILDRENS:
				_price = new ChildrensPrice();
				break;
			case REGULAR:
				_price = new RegularPrice();
				break;
			case NEW_RELEASE:
				_price = new NewReleasePrice();
				break;
			default:
				throw new IllegalArgumentException("incorrect price code");
		}
	}
	
	//��ȡ����
	double getCharge(int daysRented){
		return _price.getCharge(daysRented);
		
	}
	
	//��ȡ����
	int getFrequentRenterPoints(int daysRented){
		return _price.getFrequentRenterPoints(daysRented);
	}
	
	public Movie(String title,int priceCode){
		this._title = title;
		setPriceCode(priceCode);
	}
}
