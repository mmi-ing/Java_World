package homework;

import java.util.Scanner;

public class Main_Baseball {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scanner 객체 생성
        boolean playAgain = true; // 게임 반복 여부

        while (playAgain) {
            Baseball bb = new Baseball(); // Baseball 객체 생성
            int s_count = 0;
            int b_count = 0;
            int try_num = 0;

            // 컴퓨터의 난수 출력 (테스트용, 실제 게임에서는 숨겨야 할 수 있음)
            for (int i = 0; i < bb.com.length; i++) {
                System.out.printf("%-2d", bb.com[i]);
            }
            System.out.println(); // 줄바꿈

            // 사용자 입력 루프
            do {
                ++try_num;
                System.out.println("입력: ");
                String str = scan.next();

                // 입력한 문자 길이가 3자가 아니면 오류 메시지 출력
                if (str.length() != bb.com.length) {
                    System.out.println("잘못 입력하셨습니다.");
                } else {
                    int[] ar = new int[3];
                    boolean chk = true;

                    // 문자열을 숫자로 변환하여 배열에 저장하는 과정
                    for (int i = 0; i < ar.length; i++) {
                        char ch = str.charAt(i);
                        if (ch >= '0' && ch <= '9') {
                            int n = ch - '0';
                            ar[i] = n;
                        } else {
                            chk = false;
                            break;
                        }
                    }

                    if (chk) {
                        bb.setUser(ar);
                        s_count = bb.strikeCount();
                        b_count = bb.ballCount();
                        System.out.printf("%d회차: %d 스트라이크, %d 볼 \r\n", try_num, s_count, b_count);
                    }
                }
            } while (s_count != 3); // 스트라이크 3개일 때까지 반복

            System.out.println("축하합니다! 모든 숫자를 맞췄습니다.");
            System.out.println("다시 하시겠습니까?(y/n): ");
            String ans = scan.next();

            // 사용자가 "n" 또는 "N"을 입력하면 playAgain을 false로 설정하여 게임 종료
            playAgain = !ans.equalsIgnoreCase("n");
        }

        System.out.println("게임을 종료합니다.");
        scan.close(); // Scanner 객체 닫기
    }
}
