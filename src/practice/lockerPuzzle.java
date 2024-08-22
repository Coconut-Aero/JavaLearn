package practice;

public class lockerPuzzle {
    public static void main(String[] args) {
        boolean[] lock = new boolean[100];
        for (int i = 0; i < 100; i++) {
            lock[i] = true;
        }//第一个学生打开了所有的柜子
        for (int i = 0; i < 50; i++) {
            lock[2*i+1] = false;
        }//第二个学生关闭了相邻为1的柜子
        for (int i = 3; i < 100; i++) {
            for (int j = 1; j*i+1 < 100; j++) {
                lock[i*j] = !lock[i*j];
            }
        }
        int out = 0;
        for (int i = 0; i < 100; i++) {
            if(lock[i]){
                System.out.printf("%4s",i+1);
                out++;
            }
            if (out==10){
                System.out.println();
                out = 0;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < 100; i++) {
            if(!lock[i]){
                System.out.printf("%4s",i+1);
                out++;
            }
            if (out==10){
                System.out.println();
                out = 0;
            }
        }
    }
}
