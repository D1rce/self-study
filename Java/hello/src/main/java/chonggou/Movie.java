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

	//设置影片种类
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
	
	//获取费用
	double getCharge(int daysRented){
		return _price.getCharge(daysRented);
		
	}
	
	//获取积分
	int getFrequentRenterPoints(int daysRented){
		return _price.getFrequentRenterPoints(daysRented);
	}
	
	public Movie(String title,int priceCode){
		this._title = title;
		setPriceCode(priceCode);
	}
}
