package practice;

public class numberPyramid {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < (20-i+1) ; j++) {
                System.out.print("    ");
            }
            for (int k = 0; k < i; k++) {
                System.out.printf("%4d", (int) Math.pow(2, k));
            }
            for (int l = i; l > -1; l--) {
                System.out.printf("%4d", (int) Math.pow(2, l));
            }
            System.out.println();
        }
    }
}
