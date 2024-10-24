package pm;

public class Company {
	EmpVO[] ar = new EmpVO[4];
	
	public void init() {
		EmpVO e1 = new EmpVO();
		e1.setNum("310");
		e1.setName("김길동");
		e1.setPos("사원");
		e1.setTeam("개발1팀");
		
		EmpVO e2 = new EmpVO();
		e2.setNum("102");
		e2.setName("이김말이");
		e2.setPos("팀장");
		e2.setTeam("개발2팀");
		
		EmpVO e3 = new EmpVO();
		e3.setNum("426");
		e3.setName("이수아");
		e3.setPos("인턴");
		e3.setTeam("홍보1팀");
		
		EmpVO e4 = new EmpVO();
		e4.setNum("709");
		e4.setName("송지민");
		e4.setPos("사원");
		e4.setTeam("홍보2팀");
		
		// 그대로 두면 생성된 객체 소멸 => 배열에 저장
		ar[0] = e1;
		ar[1] = e2;
		ar[2] = e3;
		ar[3] = e4;
		
	}
	
	public String searchEmp(String n) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < ar.length; i++) {
			
			EmpVO e = ar[i];
			
			if (e.name.contains(n)) {
				sb.append(e.num);
				sb.append(" | ");
				sb.append(e.name);
				sb.append(" | ");
				sb.append(e.pos);
				sb.append(" | ");
				sb.append(e.team);
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}

}
