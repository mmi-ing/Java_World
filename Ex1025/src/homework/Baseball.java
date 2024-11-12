package homework;

public class Baseball {
	int [] com;
	int [] user;
	
	public void setUser(int[] user) {
		// 인자로 넘어온 배열을 멤버변수인 user에 저장!
		this.user = user;
	}
	// 생성자는 접근제한자를 되도록이면 public으로 지정하고 
	// 이름은 반드시 클래스명과 동일하게 지정한다.
	public Baseball() {
		// 처음 현재 객체가 생성될 때 두 개의 배열을 생성한다.
		com= new int[3];
		user = new int[3];
		
		// 컴퓨터가 가지는 난수 3개를 com이라는 배열이 가져야 한다.}
		initCom();
	}//생성자의 끝
	
	// com배열 초기화 기능
	public void initCom() {
		for(int i = 0; i<com.length; ) {
			// 먼저 난수 1개 발생!
			com[i] = (int)(Math.random()*9+1);
			boolean chk = false;		// 중복된 값이 있으면 true로 변경되어 중복값이
														// 발했는지를 체크하는 변수

			// 중복체크하는 반복
			for( int j = 0; j<i; j++) {
				if(com[i]==com[j]) {
					// 중복된 값이 난수로 발생한 경우
					chk = true;
					break;		// 가장 가까운 반복문 탈
				}
			}
			
			if (!chk)		// 현재 중복된 값이 아닐 때... i 증가
				++i;
		}	//	바깥쪽 for의 
	}	// 생성자의 
			
	// 같은 자리에 같은 값을 가진 경우를 우린 strike로 정한다.
	// 이것이 몇 개나 있는 지 알아내는 기
	public int strikeCount() {
		int count = 0;
		
		for( int i = 0; i<com.length; i++) {
			// com 배열과 user배열간의 같은 자리에
			// 같은값이 있으면 count증가!
			if(com[i] == user[i])
				count++;
		}
		return count;
	}
	
	// com배열과 user배열간의 서루 다른 자리의 값들 중
	// 같은 값이 존재하는 지 판단하고 count하는 기능
	public int ballCount() {
		int count = 0;
		
		for(int i = 0; i < com.length; i++) {
			// i 보다 1칸 뒤 비교 
			if (com[i] == user[(i+1)%com.length])
				count++;
			
			// i 보다 2칸 뒤 비교 
			if (com[i] == user[(i+2)%com.length])
				count++;
			
		}
		return count;
	}
}

