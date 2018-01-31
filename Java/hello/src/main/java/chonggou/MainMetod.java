package chonggou;

public class MainMetod {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int idaysRented = 3;
		Movie m = new Movie("白夜行" , Movie.NEW_RELEASE);
		System.err.println("标题 --> "+ m.getTitle());
		System.err.println(" 积分 --> "+  m.getFrequentRenterPoints(idaysRented));
		System.err.println(" 费用 --> "+  m.getCharge(idaysRented));
	}

}
