package ch08;

class Ex8_2 {
    public static void main(String args[]) {
        System.out.println(1);
        try {
            System.out.println(0/0);    // 예외 발생 => catch블럭으로 이동
            System.out.println(2);      // 실행되지 않는 블럭
        } catch (ArithmeticException ae)	{
            System.out.println(3);      // 실행되는 블럭
        }
        System.out.println(4);
    }
}