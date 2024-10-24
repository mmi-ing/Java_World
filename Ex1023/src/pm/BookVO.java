package pm;

public class BookVO {
	// 도서를 의미하는 클래스
	
	String name, press, pos;
	boolean rent;		// 기본값 = false
	
	public void setName(String n) {
		this.name = n;
	}

	public void setPress(String p) {
		this.press = p;
	}
	
	public void setPos(String p) {
		this.pos = p;
	}
	
	public void setRent(boolean r) {
		this.rent = r;
	}
	
	

}
