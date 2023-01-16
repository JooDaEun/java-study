package ch03;

class Ex3_9 {
    public static void main(String args[]) {
        int a = 1_000_000;          // 1,000,000  1백만 (10의 6제곱)
        int b = 2_000_000;          // 2,000,000  2백만 (10의 6제곱)

        long c = a * b;             // a * b = 2,000,000,000,000 (10의 12제곱)

        System.out.println(c);      // -1454759936
                                    // int의 범위는 10의 9제곱으로, over flow 발생
                                    // long c = (long)a * b; 와 같이 형변환 필요
                                    
    }
}