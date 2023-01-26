package ch08;

class Ex8_8 {
    public static void main(String[] args) {
        throw new RuntimeException();	// RuntimeException을 고의로 발생시킴
                                        // RuntimeException은 unchecked 예외이므로, catch문이 없어도 컴파일 OK
    }
}