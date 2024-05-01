package practice;

import homework.enhancedRandom;
import java.util.Scanner;

public class buckshotTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Player1, Player2;
        int Player1Health = 6, Player2Health = 6;
        int[] prop = buckshot.createProp();
        boolean Player1Win = false, Player2Win = false;
        boolean exit = false;
        boolean[] shellFree, shellType;
        System.out.print("Enter Player 1 's name: ");
        Player1 = input.nextLine();
        System.out.print("Enter Player 2 's name: ");
        Player2 = input.nextLine();
        while(!exit){
            shellType= buckshot.shell();
            exit = buckshot.exit();
        }
    }
}
class buckshot {
    public static boolean[] shell() {
        int n = enhancedRandom.getRandom(0, 9, 0, 1, 9);
        boolean[] shellType = new boolean[n];
        for (int i = 0; i < n; i++) {
            shellType[i] = galtonBoard.BooleanRandom();
        }
        return shellType;
    }
    public static int[] createProp (){
        int[] prop = new int[8];
        for (int i = 0; i < 8; i++) {
            prop[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            prop[i]=enhancedRandom.getRandom(0,8,0);
        }
        return prop;
    }
    public static int[] addProp(int[] prop) {
        for (int i = 0; i < prop.length; i++) {
            if (prop[i] == 0) {
                prop[i] = enhancedRandom.getRandom(0, 8, 0);
            }
        }
        return prop;
    }
    public static void printProp(int[] prop, String playerName) {
        int[] propStatic = new int[8];
        for (int i = 0; i < prop.length; i++) {
            switch (prop[i]) {
                case 0:
                    continue;
                case 1:
                    propStatic[1]++;
                case 2:
                    propStatic[2]++;
                case 3:
                    propStatic[3]++;
                case 4:
                    propStatic[4]++;
                case 5:
                    propStatic[5]++;
                case 6:
                    propStatic[6]++;
                case 7:
                    propStatic[7]++;
            }
        }
        for (int i = 1; i < propStatic.length; i++) {
            switch (propStatic[i]) {
                case 1:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " cigarette(s).");
                case 2:
                    System.out.println("Player" + playerName + " has " + propStatic[i] + " knife(ves).");
                case 3:
                    System.out.println("Player" + playerName + " has " + propStatic[i] + " drug(s).");
                case 4:
                    System.out.println("Player" + playerName + " has " + propStatic[i] + " magnifying glass(es)");
                case 5:
                    System.out.println("Player" + playerName + " has " + propStatic[i] + " adrenaline");
                case 6:
                    System.out.println("Player" + playerName + " has " + propStatic[i] + " special phone");
                case 7:
                    System.out.println("Player" + playerName + " has " + propStatic[i] + " reverser");
            }
        }
    }
    public static boolean drugEffect(){
        return galtonBoard.BooleanRandom();
        /*
            ture：代表起效
            false：代表副作用
         */
    }
    public static boolean magnifyingGlass(boolean shell){
        return (shell);
    }
    public static boolean SpecialPhone(boolean[] shell){
        return (shell[enhancedRandom.getRandom(0, shell.length, 0,9)]);
    }
    public static boolean reverser(boolean shell){
        return (!shell);
    }
    public static void PrintHealth(int Player1Health, int Player2Health, int Player1Name, int Player2Name){
        System.out.println("Player1 Named: "+ Player1Name + "have health " + Player1Health);
        System.out.println("Player2 Named: "+ Player2Name + "have health " + Player2Health);
    }
    public static boolean shellFree (boolean[] shellFree){
        for (int i = 0; i < shellFree.length; i++) {
            if (!shellFree[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean exit (){
        Scanner input = new Scanner(System.in);
        System.out.print("Play Again? (Y/N): ");
        while (true) {
            String exit= input.nextLine();
            if(exit.equals("Y")||exit.equals("y")){
                return true;
            }
            else if(exit.equals("N")||exit.equals("n")){
                return false;
            }
            else {
                System.out.print("Your input is incorrect, please try again: ");
            }
        }
    }
}


/*
    道具：
        1：回血烟
        2：刀
        3：药物
        4：放大镜
        5：肾上腺素
        6：特殊手机
        7：逆转器
 */