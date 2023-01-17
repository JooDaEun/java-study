package ch06;


class Ex6_3 {
    public static void main(String args[]) {
        // cv는 객체 생성 없이 사용 가능 - 클래스가 메모리에 올라가면서 자동으로 생성
        System.out.println("Card.width = " + Card.width);    // 100
        System.out.println("Card.height = " + Card.height);  // 250

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");  // Heart, 7, 100, 250
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");  // Spade, 4, 100, 250
        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
        c1.width = 50;      // -> Card.width = 50;
        c1.height = 80;     // -> Card.width = 80;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");  // Heart, 7, 50, 80
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");  // Spade, 4, 50, 80
    }
}

class Card {                    // 클래스 영역
    String kind;                // 인스턴스 변수 iv : 객체생성 필요
    int number;                 // 개별 카드마다 다르게 적용되어야 함
    static int width = 100;     // 클래스 변수 cv (static + iv) : 객체생성 필요 X
    static int height = 250;    // 모든 카드에 공통적으로 적용되어야 함
}