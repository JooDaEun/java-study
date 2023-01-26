package ch09;

class Person {
    long id;

    // equals(Object obj) 오버라이딩
    public boolean equals(Object obj) {
        if(obj instanceof Person)
            return id ==((Person)obj).id;   // obj가 Object 타입이므로 id값을 참조하기 위해 Person으로 형변환
        else
            return false;                   // 타입이 Person이 아니면 값을 비교할 필요가 없음
    }

    Person(long id) {
        this.id = id;
    }
}

class Ex9_2 {
    public static void main(String[] args) {
        Person p1 = new Person(8011081111222L);
        Person p2 = new Person(8011081111222L);

        if(p1.equals(p2))   // true
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
    }
}