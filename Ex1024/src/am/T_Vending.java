package am;

public class T_Vending {
	// 자판기를 의미하는 클래스!
	// 현 자판기는 4개의 음료를 가진다.
	
	DrinkVO[] ar = new DrinkVO[4];
	
	// 배열에 음료객체 4개를 생성하여 초기화하는 동작
	public void init() {
		DrinkVO d1 = new DrinkVO();
		d1.setName("레츠비");
		d1.setPrice(500);
		
		DrinkVO d2 = new DrinkVO();
		d2.setName("사이다");
		d2.setPrice(700);
		
		DrinkVO d3 = new DrinkVO();
		d3.setName("콜라");
		d3.setPrice(800);
		
		DrinkVO d4 = new DrinkVO();
		d4.setName("웰치스");
		d4.setPrice(900);
		
		ar[0] = d1;
		ar[1] = d2;
		ar[2] = d3;
		ar[3] = d4;
		
	}	//초기화 함수 끝 
	
	// 금액을 인자로 받아서 해당 금액에 선택 가능한 
	// 음료의 이름을 하나로 모아 전달하는 동작 
	public String insertCoin(int money) {
		// 배열에 저장된 각 음료의 가격과 인자로 받은 money를 비교하여
		// money가 크거나 같다면 해당 음료의 이름을 문자열로 조합하여 반환하는 기능
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < ar.length; i++) {
			if (money >= ar[i].getPrice()) {
				sb.append(ar[i].getName()); 	// 음료이름을 sb에 적재
				sb.append(":");
				sb.append(i+1);
				sb.append(",");
			}
		} // for의 끝
		// 마지막에 있는 ","를 삭제
		// 그렇다면 마지막에 있는 ","의 위치값(index)을 알아내야 한다.
		// 위치 알아내는 기능 : indexOf(",") : 검색 기준이 왼쪽부터
		//								  lastIndexOf(",") : 검색 기준이 오른쪽부터
		int idx = sb.lastIndexOf(",");
		
		// sb의 0번지부터 idx전까지 문자열 추출
		String msg = sb.substring(0, idx);
		return msg;
	}
	
	// 사용자가 선택한 음료번호와 사용자가 이전 입력한 금액을 인자로 받아서
	// 해당 음료 객체를 배열로 얻어내어
	// (사용자가 입력한 금액) - (선택한 음료의 가격) =  거스름돈 
	public String change(int num, int money) {
		StringBuffer sb = new StringBuffer("선택하신 음료: ");
		
		// 사용자가 선택한 음료번호에서 -1 한 후 그것을 배열의 index로 사용하자!
		DrinkVO d = ar[num-1];
		int change = money-d.getPrice();	// 거스름 돈
		
		sb.append(d.getName());		// 음료명 추가
		sb.append(", 잔돈");
		sb.append(": ");
		sb.append(change);
		sb.append("원");
		
		return sb.toString();
		
	}
	
}
