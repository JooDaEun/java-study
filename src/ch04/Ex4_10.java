package ch04;

class Ex4_10 {
    public static void main(String[] args) {
        int sum = 0;

        for(int i=1; i <= 5; i++) {
            sum += i;  // sum = sum + i;
            System.out.printf("1부터 %2d 까지의 합: %2d%n", i, sum);
            // 1부터  1 까지의 합:  1
            // 1부터  2 까지의 합:  3
            // 1부터  3 까지의 합:  6
            // 1부터  4 까지의 합: 10
            // 1부터  5 까지의 합: 15
        }
    }
}