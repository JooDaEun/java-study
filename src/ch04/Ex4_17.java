package ch04;

class Ex4_17 {
    public static void main(String[] args) {
        for(int i =0; i <= 10; i++) {
            if (i % 3 == 0) continue;
            System.out.println(i);
            //1
            //2
            //4
            //5
            //7
            //8
            //10
        }
    }
}