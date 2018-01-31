package knights;

public class CDPlayer {
	private CompactDisc cd;
	
	public CDPlayer(CompactDisc cd){
		this.cd = cd;
	}
	public void paly(){
		cd.play();
	}
}
