package homework;

public class EmpVO {
	
	String num;			// 사번
	String name;		// 이름
	String pos;			// 직책
	String dept;		// 부서명

	public String getEmpno() {
		return num;
	}
	public void setEmpno(String num) {
		this.num = num;
	}
	public String getEname() {
		return name;
	}
	public void setEname(String name) {
		this.name = name;
	}
	public String getPosition() {
		return pos;
	}
	public void setPosition(String pos) {
		this.pos = pos;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

}
