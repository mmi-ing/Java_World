package homework;

public class AnimalTest {
	
    public static void main(String[] args) {
        // 나이 3살, 이름 "큰뿔소", 생존 여부 true인 Animal 객체 생성
        Animal animal = new Animal("큰뿔소", 3, true);

        // 이름과 생존 여부 출력
        System.out.println("이름: " + animal.getName());
        System.out.println("생존 여부: " + (animal.getLive() ? "살아 있음" : "살아 있지 않음"));

        System.out.println();
        
        // 이름을 펭귄으로 변경
        animal.setName("펭권");

        // 이름과 생존 여부 다시 출력
        System.out.println("변경된 이름: " + animal.getName());
        System.out.println("생존 여부: " + (animal.getLive() ? "살아 있음" : "살아 있지 않음"));
    }
}
