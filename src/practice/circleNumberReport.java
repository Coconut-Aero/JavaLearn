package practice;

import java.util.Scanner;
import homework.enhancedRandom;
import static practice.Constants.N;

public class circleNumberReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, k, position = enhancedRandom.getRandomExcept(0, N,100), tmp=0;
        boolean[] exit = new boolean[N];
        System.out.print("Enter m and k ");
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < 100; ++i) {
            exit[i] = false;
        }
        System.out.print("These person will exit:");
        for (int i = 0; i < k; ++i) {
            for (int j = position + k; j<N; ++j) {
                if(exit[j]){
                    continue;
                }
                if(j== N-1){
                    j=-1;
                }
                if(tmp == m){
                    System.out.printf("%5d",j);
                    exit[j] = true;
                    break;
                }
                tmp++;
            }
        }
        System.out.println();
        System.out.print("These person will not exit:");
        for (int i = 0; i < N; ++i) {
            if(!exit[i]) System.out.printf("%5d",i);
        }
    }
}
class Constants {
    public static final int N = 100;
}

