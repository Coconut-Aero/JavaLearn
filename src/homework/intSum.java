package homework;

public class intSum {
    public static void main(String[] args) {
        int Sum = 0;
        System.out.print(args[0]);
        for (int i = 0; i < args.length; i++) {
            Sum += Integer.parseInt(args[i]);
            if(i<=args.length-2){
                System.out.print("+" + args[i+1]);
            }
            else{
                System.out.print("=");
            }
        }
        System.out.print(Sum);
    }
}
