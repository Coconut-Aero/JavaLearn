package draft;

import java.util.Scanner;

public class powerOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = (int) Math.pow(2,n);
        System.out.print(res);
    }
}
