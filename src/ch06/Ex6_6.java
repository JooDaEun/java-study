package ch06;

class Data { int x; }

class Ex6_6 {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);      // 10

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);      // 10
    }

        static void change(int x) {                     // 기본형 매개변수
        x = 1000;                                       // 지역변수인 x를 바꾼 것!
        System.out.println("change() : x = " + x);      // 1000
    }
}
