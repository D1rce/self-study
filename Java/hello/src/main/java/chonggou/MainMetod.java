package chonggou;

public class MainMetod {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int idaysRented = 3;
		Movie m = new Movie("��ҹ��" , Movie.NEW_RELEASE);
		System.err.println("���� --> "+ m.getTitle());
		System.err.println(" ���� --> "+  m.getFrequentRenterPoints(idaysRented));
		System.err.println(" ���� --> "+  m.getCharge(idaysRented));
	}

}
