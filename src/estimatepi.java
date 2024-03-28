public class estimatepi {
    public static double pi(int i) {
        double result = 0;
        for (int j = 1; j < i; j++) {
            result += ((int)(Math.pow((-1),(j+1)))/(2.0*j-1));
        }
        result *= 4;
        return result;
    }
    public static void main(String[] args) {
        System.out.printf("%9s%10s","i","m(i)");
        System.out.println();
        for (int i = 1; i <= 100000000; i++) {
            double res = pi(i);
            System.out.printf("%9s%10.9s",i,res);
            System.out.println();
        }
    }
}
