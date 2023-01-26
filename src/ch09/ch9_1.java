package ch09;

class Ex9_1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if (v1.equals(v2)) {                            // [오버라이딩 전] false 반환
            System.out.println("v1과 v2는 같습니다");
        }
        else {
            System.out.println("v1과 v2는 다릅니다");
        }
    }
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }

    // Object의 equals()를 오버라이딩
    public boolean equals(Object obj) {
        // return this == obj                 // [기본] 주소비교

        // 참조변수의 형변환 전에는 반드시 instanceof로 확인해야 함
        if(!(obj instanceof Value)) return false;

        Value v = (Value)obj;                 // obj를 value로 형변환
        return this.value == v.value;         // [오버라이딩 후] value 비교 => true 반환
    }
}