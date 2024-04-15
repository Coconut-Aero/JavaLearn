import java.util.Scanner;

public class sorted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter some number and I will tell you whether is it shorted.");
        System.out.print("Enter the size of the list:");
        int size = input.nextInt();
        int[] list =new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the number #" + (i+1) + ":");
            list[i]=input.nextInt();
        }
        boolean IsShorted = IsSorted(list);
        System.out.print("The list have " + size +" integers:");
        arraytest.printArr(list,size);
        if (!IsShorted){
            System.out.println("The list is not shorted.");
        }else {
            System.out.println("The list is shorted.");
        }
    }
    public static boolean IsSorted(int[] list){
        for (int i = 0; i < list.length - 1; i++) {
            if(list[i] > list[i+1]){
                return false;
            }
        }
        return true;
    }
    public static int[] Sort(int[] res){
        if(!sorted.IsSorted(res)) {
            for (int i = 0; i < res.length-1; i++) {
                if (res[i] > res[i + 1]) {
                    int tmp;
                    tmp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = tmp;
                    i = 0;
                }
            }
        }
        return res;
    }
}
