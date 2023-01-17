package ch06;

class Ex6_4 {
    public static void main(String args[]) {
        MyMath mm = new MyMath();   // 2. MyMath 객체 생성

        // 3. MyMath 객체 사용 (객체의 메서드 호출)
        long result1 = mm.add(5L, 3L);
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);
        long result5 = mm.max(5L, 3L);

        System.out.println("add(5L, 3L) = " + result1);         // 8
        System.out.println("subtract(5L, 3L) = " + result2);    // 2
        System.out.println("multiply(5L, 3L) = " + result3);    // 15
        System.out.println("divide(5L, 3L) = " + result4);      // 1.6666666666666667
        System.out.println("max(5L, 3L) = " + result5);         // 5
    }
}

class MyMath {  // 1. MyMath 클래스 작성 (메서드 작성)
    long add(long a, long b) {
        long result = a + b;
        return result;
        //	return a + b;
    }
    long max(long a, long b) {
        return a > b ? a : b ;
    }
    long subtract(long a, long b) { return a - b; }
    long multiply(long a, long b) { return a * b; }
    double divide(double a, double b) {
        return a / b;
    }
}