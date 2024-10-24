package am;

public class Test4Pen {
	// 속성
	String color = "검정";
	String comp = "모나미";
	int price = 2000;
	
	// 동작
	// 5번 행에 있는 color라는 변수의 값을 변경하는 동작
	public void setColor(String n) {
		// 현재 메서드를 호출할 때 전달하는 인자가 n에 담기고
		// 그 n의 값을 현재 객체 안에 있는 color라는 변수에 저장한다.
		this.color = n;
	}
	
	// 5번 행에 있는 color의 값을 반환하는 동작
	public String getColor() {
		return this.color;
	}
}
