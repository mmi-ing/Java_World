package pm;

public class CarEx2 {
	// 자동차를 의미하는 클래스
	String model; // 모델명
	int price; // 가격
	String maker; 	// 제조사
	
	// 모델명을 변경하는 기능
	public void setModel (String n) {
		// 인자를 받아서 model이라는 멤버변수에 저장한다.
		this.model = n;
		System.out.println("CarEx2의 setModel 수행");
	}
	
	// 오버라이딩(재정의)
	// 부모와 자식이 똑같은 함수가 있다면 부모의 함수가 숨겨지고 자식의 함수가 우선순위를 가진다
	public void print() {
		System.out.println("print");
	}
}
