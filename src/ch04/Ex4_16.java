package ch04;

class Ex4_16 {
    public static void main(String[] args) {
        int sum = 0;
        int i   = 0;

        while(true) {   // 무한반복문
            if(sum > 100) break;
            ++i;
            sum += i;
        }
        System.out.println("i=" + i);
        System.out.println("sum=" + sum);
    }
}