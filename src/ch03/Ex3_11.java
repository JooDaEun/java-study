package ch03;

class Ex3_11 {

    // Math.round (반올림)
    // 실수를 소수점 첫째자리에서 반올림한 정수를 반환
    // n+1자리에서 반올림 하고 싶다면, 10의 n제곱을 곱해서 반올림한 후 10의 n제곱으로 나누는 방법 사용

    public static void main(String args[]) {
        double pi = 3.141592;
        double shortPi = Math.round(pi * 1000) / 1000.0;
                      // Math.round(3141.592) / 1000.0
                      // 3142 / 1000.0

        System.out.println(shortPi);  // 3.142
    }
}
