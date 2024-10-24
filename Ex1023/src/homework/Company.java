package homework;

public class Company {
	// 사원(EmpVO) 4명을 저장할 곳!!! (배열)
	EmpVO[] ar = new EmpVO[4];
	
	// 비어있는 배열을 원하는 사원정보들로 채우는 초기화 함수
	public void init() {
		EmpVO e1 = new EmpVO();
		e1.setEmpno("122");
		e1.setEname("이도");
		e1.setPosition("팀장");
		e1.setDept("개발1팀");

		EmpVO e2 = new EmpVO();
		e2.setEmpno("205");
		e2.setEname("아라치");
		e2.setPosition("사원");
		e2.setDept("기획1팀");
		
		EmpVO e3 = new EmpVO();
		e3.setEmpno("529");
		e3.setEname("창조리");
		e3.setPosition("과장");
		e3.setDept("개발1팀");
		
		EmpVO e4 = new EmpVO();
		e4.setEmpno("365");
		e4.setEname("마루치");
		e4.setPosition("사원");
		e4.setDept("개발2팀");
		
		// 앞서 생성한 사원객체들을 배열 각 요소에 저장한다.
		ar[0] = e1;
		ar[1] = e2;
		ar[2] = e3;
		ar[3] = e4;
	}
	
	// 검색기능
	public String searchEmp(int n, String value) {
		
		// 인자인 value가 null이거나 공백일 경우에는 null값을 보낸다.
		if(value == null || value.trim().length() == 0)
			return null;	// 호출한 곳으로 null을 반환하면서 돌어간다.
		
		StringBuffer sb = new StringBuffer(); 		// 문자열 편집을 위해 필요한 객체
		
		
		for (int i= 0; i < ar.length; i++ ) {
			// 먼저 배열로부터 한 개의 요소(EmpVO)를 얻어낸다.
			EmpVO e = ar[i];
			boolean chk = false;
			
			switch(n) {
				case 1: 
					// 얻어낸 사원객체의 이름 안에 인자로 받은 value가
					// 포함되었다면 sb에 적재한다.
					if(e.getEmpno().contains(value))
						chk = true;
					break;
				case 2: 
					if(e.getEname().contains(value))
						chk = true;
					break;
				case 3: 
					if(e.getPosition().contains(value))
						chk = true;
					break;
				case 4: 
					if(e.getDept().contains(value))
						chk = true;
					break;
			}	// switch의 끝
			
			// 얻어낸 사원객체의 이름 안에 인자로 받은 value가
			// 포함되었다면 sb에 적재한다.
				
			if(chk) {	//chk가 true일 때
				sb.append(e.getEmpno());
				sb.append(" | ");
				sb.append(e.getEname());
				sb.append(" | ");
				sb.append(e.getPosition());
				sb.append(" | ");
				sb.append(e.getDept());
				sb.append("\r\n");	// 줄바꿈
			}	// if문의 끝
		}	//for의 끝
		return sb.toString();	// 호출한 곳으로 sb의 내용을 문자열로 반환한다.
	}	// searchEmp 함수의 끝
}	// 클래스의 끝
