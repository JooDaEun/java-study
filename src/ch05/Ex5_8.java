package ch05;

class Ex5_8 {
    public static void main(String[] args) {
        int[][] score = {
            { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }
        };
        int sum = 0;

        for (int i = 0 ; i < score.length ; i++) {
            for (int j = 0 ; j < score[i].length ; j++) {
                System.out.printf("score[%d][%d]=%d%n", i, j, score[i][j]);
                //score[0][0]=100
                //score[0][1]=100
                //score[0][2]=100
                //score[1][0]=20
                //score[1][1]=20
                //score[1][2]=20
                //score[2][0]=30
                //score[2][1]=30
                //score[2][2]=30
                //score[3][0]=40
                //score[3][1]=40
                //score[3][2]=40
                sum += score[i][j];
            }
        }
        System.out.println("sum = " + sum);
        //sum = 570
    }
}