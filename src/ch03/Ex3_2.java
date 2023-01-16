package ch03;

class Ex3_2 {
    public static void main(String args[]) {
        int i = 5, j = 0;

        j = i++;
        System.out.println("j=i++; 실행 후, i=" + i +", j="+ j);   // j=i++; 실행 후, i=6, j=5

        // i와 j의 값을 다시 5와 0으로 변경
        i = 5; j = 0;

        j = ++i;
        System.out.println("j=++i; 실행 후, i=" + i +", j="+ j);   // j=++i; 실행 후, i=6, j=6
    }
}