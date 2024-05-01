package practice;

import homework.arrayTest;

import java.util.Scanner;

public class mergeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list1 size and contents ");
        int size1 = input.nextInt();
        int[] list1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            list1[i] = input.nextInt();
        }
        System.out.print("Enter list2 size and contents ");
        int size2 = input.nextInt();
        int[] list2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            list2[i] = input.nextInt();
        }
        int[] shortedList1 = sorted.Sort(list1);
        int[] shortedList2 = sorted.Sort(list2);
        System.out.print("list1 is ");
        arrayTest.printArr(shortedList1,size1);
        System.out.print("list2 is ");
        arrayTest.printArr(shortedList2,size2);
        int[] merged = merge(shortedList1,shortedList2);
        System.out.print("The merged list is ");
        arrayTest.printArr(merged,size1+size2);
    }
    public static int[] merge(int[] list1,int[] list2){
        int[] res = new int[list1.length+list2.length];
        System.arraycopy(list1, 0, res, 0, list1.length);
        System.arraycopy(list2, 0, res, list1.length, list2.length);
        return sorted.Sort(res);
    }
}
