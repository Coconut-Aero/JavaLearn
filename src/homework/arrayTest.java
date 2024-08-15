package homework;

import java.util.*;
public class arrayTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = input.nextInt();
        }
        printIntArray(arr,6);
        int a = arr[0];
        for (int j = 0; j < 5; j++) {
            arr[j] = arr[j+1];
        }
        arr[5] = a;
        printIntArray(arr,6);
        for (int j = 0; j < 3; j++) {
            int m = arr[j];
            int n = arr[5-j];
            arr[j]=n;
            arr[5-j]=m;
        }
        printIntArray(arr,6);
        for (int m = 0; m < 3; m++) {
            int q =(int) (Math.random() * 3);
            int p =(int) (Math.random() * 3 + 3);
            int r = arr[q];
            int s = arr[p];
            arr[q] = s;
            arr[p] = r;
        }
        printIntArray(arr,6);
    }
    public static void printIntArray(int[] arr, int size){
        for (int k = 0; k < size; k++) {
            System.out.printf("%5d",arr[k]);
        }
        System.out.println();
    }
    public static void printStringArray(String[] arr,int size){
        for (int k = 0; k < size; k++) {
            System.out.printf("%5s",arr[k]);
        }
        System.out.println();
    }
    public static void printStringArrayNoSpace(String[] arr,int size){
        for (int k = 0; k < size; k++) {
            System.out.print(arr[k]);
        }
        System.out.println();
    }
}
