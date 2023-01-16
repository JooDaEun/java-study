package ch04;

class Ex4_19 {
    public static void main(String[] args) {
        Loop1: // Loop1이라는 이름의 for문
        for(int i = 2; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(j == 5)
                    break Loop1;
//					break;
//					continue Loop1;
//					continue;
                System.out.println(i + " * " + j + " = " + i*j);
            }
            System.out.println();
        }

    }
}