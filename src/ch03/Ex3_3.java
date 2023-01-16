package ch03;

class Ex3_3 {
    public static void main(String args[]) {
        int i = 5, j = 5;
        System.out.println(i++);                            // 5 : 출력 후, 1 증가
        System.out.println(++j);                            // 6 : 1 증가 후, 출력
        System.out.println("i = " + i + ", j = " +j);       // i = 6, j = 6
    }
}