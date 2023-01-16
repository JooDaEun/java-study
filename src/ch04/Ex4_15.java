package ch04;

import java.util.*;

class Ex4_15 {
    public static void main(String[] args) {
        int input, answer;

        answer = (int)(Math.random() * 100) + 1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("[UP&DOWN GAME]");
            System.out.print("1과 100사이의 정수를 입력하세요 > ");
            input = scanner.nextInt();

            if(input > answer) {
                System.out.println("DOWN!");
            }
            else if(input < answer) {
                System.out.println("UP!");
            }
        }
        while(input != answer);

        System.out.println("정답입니다!");
    }
}