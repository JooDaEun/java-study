package ch04;


import java.util.Scanner;

class Ex4_4 {
    public static void main(String[] args) {
        int score  = 0;      // 점수를 저장하기 위한 변수
        char grade = ' ';    // 학점을 저장하기 위한 변수. 공백으로 초기화

        System.out.print("점수를 입력하세요 > ");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        if (score >= 90) {         // 90점 이상 A학점
            grade = 'A';
        }
        else if (score >= 80) {    // 80점 이상 B학점
            grade = 'B';
        }
        else if (score >= 70) {    // 70점 이상 C학점
            grade = 'C';
        }
        else {                     // 나머지 D학점
            grade = 'D';
        }
        System.out.println("당신의 학점은 " + grade + " 입니다");
    }
}
