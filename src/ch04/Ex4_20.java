package ch04;

import java.util.*;

class Ex4_20 {
    public static void main(String[] args) {
        int menu, num;
        Scanner scanner = new Scanner(System.in);

        // outer라는 이름의 while문
        outer:
        while(true) {
            System.out.println("[보기]]");
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");
            System.out.print("원하시는 활동(1~3)을 선택하세요 (종료: 0) > ");

            String tmp = scanner.nextLine();
            menu = Integer.parseInt(tmp);

            if(menu == 0) {
                System.out.println("[프로그램 종료]");
                break;
            }
            else if (!(1 <= menu && menu <= 3)) {
                System.out.println("보기에 존재하는 번호를 입력하세요 (종료: 0)");
                continue;
            }

            for(;;) {   // 무한 반복문 for(;true;)
                System.out.print("계산할 값을 입력하세요 (계산 종료: 0, 전체 종료: 99) > ");
                tmp = scanner.nextLine();
                num = Integer.parseInt(tmp);

                if(num == 0)
                    break;        // for문을 벗어남 - 계산 종료

                if(num == 99)
                    break outer;  // for문과 while문을 모두 벗어남 - 전체 종료

                switch(menu) {
                    case 1:
                        System.out.println("result = " + num * num);
                        break;
                    case 2:
                        System.out.println("result = " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result = " + Math.log(num));
                        break;
                }
            }
        }
    }
}