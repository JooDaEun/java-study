package ch04;

import java.util.*;

class Ex4_18 {
    public static void main(String[] args) {
        int menu;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("[MENU]");
            System.out.println("(1) pizza");
            System.out.println("(2) hamburger");
            System.out.println("(3) pasta");
            System.out.print("원하는 메뉴(1~3)를 선택하세요 (종료 : 0) > ");

            String tmp = scanner.nextLine();
            menu = Integer.parseInt(tmp);

            if(menu == 0) {
                System.out.println("[프로그램 종료]");
                break;
            }
            else if (!(1 <= menu && menu <= 3)) {
                System.out.println("메뉴 중 존재하는 번호를 입력하세요 (종료는 0)");
                continue;
            }
            System.out.println("선택하신 메뉴는 " + menu + "번 입니다.");
        }
    }
}