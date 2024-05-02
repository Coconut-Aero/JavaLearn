package practice;

import homework.enhancedRandom;

import java.util.Objects;
import java.util.Scanner;

public class buckshotTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Player1Name, Player2Name, useProp = "", activePlayer = "", shotWho;
        int Player1Health = 6, Player2Health = 6, playWho;
        int[] Player1Prop = buckshot.createProp(), Player2Prop = buckshot.createProp();
        boolean Player1Win = false, Player2Win = false, shotType;
        boolean exit = false, knifeMore = false, Player1NoMove = false, Player2NoMove = false;
        boolean[] shellType;
        System.out.print("Enter Player 1 's name: ");
        Player1Name = input.nextLine();
        System.out.print("Enter Player 2 's name: ");
        Player2Name = input.nextLine();
        while(!exit){
            for(int i = 0; i < 3; i++){
                while (Player1Health > 0 && Player2Health > 0){
                    shellType = buckshot.shell();
                    playWho = 1;
                    for(int j = 0; j < shellType.length; j++){
                        buckshot.PrintHealth(Player1Health,Player2Health,Player1Name,Player2Name);
                        buckshot.printProp(Player1Prop , Player1Name);
                        buckshot.printProp(Player2Prop , Player2Name);
                        if (playWho == 1){
                            while (!useProp.equals("no")){
                                activePlayer = Player1Name;
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                buckshot.PrintHealth(Player1Health,Player2Health,Player1Name,Player2Name);
                                buckshot.printProp(Player1Prop , Player1Name);
                                buckshot.printProp(Player2Prop , Player2Name);
                                System.out.println("It's " + activePlayer + "'s turn !");
                                System.out.println("If you would not to use prop, you can just input \" no\"");
                                System.out.println("Usage: cigarette/knife/drug/handcuff/magnify/adrenaline/phone/reverser/no");
                                System.out.print( activePlayer + " , which prop would you like to use ? >: ");
                                useProp = input.nextLine();
                                switch (useProp){
                                    case "cigarette":
                                        if(Player1Health != 6) {
                                            Player1Health++;
                                        }
                                    case "knife":
                                        knifeMore = true;
                                    case "drug":
                                        boolean a = buckshot.drugEffect();
                                        if(a){
                                            Player1Health += 2;
                                        }else{
                                            Player1Health--;
                                        }
                                    case "handcuff":
                                        Player2NoMove = true;
                                    case "magnify":
                                        buckshot.magnifyingGlass(shellType[j]);
                                    case "adrenaline":
                                        buckshot.adrenaline(Player2Prop,Player1Prop,Player1Name,Player2Name);
                                    case "phone":
                                        buckshot.SpecialPhone(shellType);
                                    case "reverser":
                                        buckshot.reverser(shellType , j);
                                }
                            }
                            System.out.println("SHOT TIME. It's " + activePlayer + "'s turn !");
                            System.out.println("You are going to shot who? (You/Opposite)");
                            shotWho = input.nextLine();
                            shotType=buckshot.shot(shellType[j]);
                            if(shotType){
                                System.out.println("REAL SHELL!");
                                if (Player2NoMove){
                                    playWho = 1;
                                }
                                else playWho = 2;
                                if (Objects.equals(shotWho, "You")){
                                    Player1Health--;
                                }
                                else if (Objects.equals(shotWho, "Opposite")){
                                    Player2Health--;
                                }
                                Player2NoMove = false;
                            }
                            else {
                                System.out.println("NO SHELL!");
                                Player2NoMove = false;
                            }
                        }
                        else if (playWho == 2){
                            while (!useProp.equals("no")){
                                activePlayer = Player2Name;
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                buckshot.PrintHealth(Player1Health,Player2Health,Player1Name,Player2Name);
                                buckshot.printProp(Player1Prop , Player1Name);
                                buckshot.printProp(Player2Prop , Player2Name);
                                System.out.println("It's " + activePlayer + "'s turn !");
                                System.out.println("If you would not to use prop, you can just input \" no\"");
                                System.out.println("Usage: cigarette/knife/drug/handcuff/magnify/adrenaline/phone/reverser/no");
                                System.out.print( activePlayer + " , which prop would you like to use ? >: ");
                                useProp = input.nextLine();
                                switch (useProp){
                                    case "cigarette":
                                        if(Player2Health != 6) {
                                            Player2Health++;
                                        }
                                    case "knife":
                                        knifeMore = true;
                                    case "drug":
                                        boolean a = buckshot.drugEffect();
                                        if(a){
                                            Player2Health += 2;
                                        }else{
                                            Player2Health--;
                                        }
                                    case "handcuff":
                                        Player1NoMove = true;
                                    case "magnify":
                                        buckshot.magnifyingGlass(shellType[j]);
                                    case "adrenaline":
                                        buckshot.adrenaline(Player1Prop,Player2Prop,Player2Name,Player1Name);
                                    case "phone":
                                        buckshot.SpecialPhone(shellType);
                                    case "reverser":
                                        buckshot.reverser(shellType , j);
                                }
                            }
                            System.out.println("SHOT TIME. It's " + activePlayer + "'s turn !");
                            System.out.println("You are going to shot who? (You/Opposite)");
                            shotWho = input.nextLine();
                            shotType=buckshot.shot(shellType[j]);
                            if(shotType){
                                System.out.println("REAL SHELL!");
                                if (!Player1NoMove){
                                    playWho = 1;
                                }
                                if (Objects.equals(shotWho, "You")){
                                    if (!knifeMore){
                                        Player1Health--;
                                    }
                                    else Player1Health -= 2;
                                }
                                else if (Objects.equals(shotWho, "Opposite")){
                                    if (!knifeMore){
                                        Player2Health--;
                                    }
                                    else Player2Health -= 2;
                                }
                            }
                            else {
                                System.out.println("NO SHELL!");
                            }
                            Player2NoMove = false;
                        }
                        if (Player1Health == 0 || Player2Health == 0){
                            break;
                        }
                    }
                    if (Player1Health == 0 || Player2Health == 0){
                        break;
                    }
                    buckshot.addProp(Player1Prop);
                    buckshot.addProp(Player2Prop);
                }
                if (Player1Health == 0) Player2Win = true;
                else if (Player2Health == 0) Player1Win = true;
            }
            if (Player1Win){
                System.out.println(Player1Name + " has won!");
            }
            else if (Player2Win){
                System.out.println(Player2Name + " has won!");
            }
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
        int[] prop = new int[9];
        for (int i = 0; i < 8; i++) {
            prop[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            prop[i]=enhancedRandom.getRandom(0,9,0);
        }
        return prop;
    }
    public static void addProp(int[] prop) {
        for (int i = 0; i < prop.length; i++) {
            if (prop[i] == 0) {
                prop[i] = enhancedRandom.getRandom(0, 8, 0);
            }
        }
    }
    public static void printProp(int[] prop, String playerName) {
        int[] propStatic = propStatic(prop);
        for (int i = 1; i < propStatic.length; i++) {
            switch (propStatic[i]) {
                case 1:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " cigarette(s).");
                case 2:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " knife(ves).");
                case 3:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " drug(s).");
                case 4:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " handcuff(s)");
                case 5:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " magnifying glass(es)");
                case 6:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " adrenaline");
                case 7:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " special phone");
                case 8:
                    System.out.println("Player " + playerName + " has " + propStatic[i] + " reverser");
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
    public static void magnifyingGlass(boolean shell){
        if(shell){
            System.out.println(" REAL SHELL");
        }
        else {
            System.out.println(" NOT REAL SHELL");
        }
    }
    public static void SpecialPhone(boolean[] shell){
        int i = enhancedRandom.getRandom(0, shell.length, 0,9);
        if (shell[i]){
            System.out.println("Shell " + i + " is a real shell.");
        }
        else System.out.println("Shell " + i + " is not a real shell.");
    }
    public static void reverser(boolean[] shell, int i){
        shell[i] = !shell[i];
    }
    public static void PrintHealth(int Player1Health, int Player2Health, String Player1Name, String Player2Name){
        System.out.println("Player1 Named: "+ Player1Name + "have health " + Player1Health);
        System.out.println("Player2 Named: "+ Player2Name + "have health " + Player2Health);
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
    public static boolean shot (boolean shellType){
        return shellType;
    }
    public static void adrenaline(int[] NegativePlayerProp, int[] PositivePlayerProp, String PositivePlayerName, String NegativePlayerName){
        Scanner input = new Scanner(System.in);
        System.out.println("You are gonna to take which? ");
        System.out.println("Usage: cigarette/knife/drug/handcuff/magnify/adrenaline/phone/reverser");
        String putin = input.nextLine();
        boolean putSuccess = false;
        int put = 0;
        int[] propStatic = propStatic(NegativePlayerProp);
        switch (putin) {
            case "cigarette":
                if (propStatic[1] != 0){
                    put = 1;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have cigarette!");
                }
            case "knife":
                if (propStatic[2] != 0){
                    put = 2;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have knife!");
                }
            case "drug":
                if (propStatic[3] != 0){
                    put = 3;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have drug!");
                }
            case "handcuff":
                if (propStatic[4] != 0){
                    put = 4;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have handcuff!");
                }
            case "magnify":
                if (propStatic[5] != 0){
                    put = 5;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have magnify!");
                }
            case "adrenaline":
                if (propStatic[6] != 0){
                    put = 6;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have adrenaline!");
                }
            case "phone":
                if (propStatic[7] != 0){
                    put = 7;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have special phone!");
                }
            case "reverser":
                if (propStatic[8] != 0){
                    put = 8;
                }else {
                    System.out.println("Player " + NegativePlayerName + "doesn't have reverser!");
                }
        }
        for (int i = 0; i < PositivePlayerProp.length; i++) {
            if (PositivePlayerProp[i] == 0) {
                PositivePlayerProp[i] = put;
                putSuccess = true;
            }
        }
        if (!putSuccess){
            System.out.println("Player " + PositivePlayerName + " has no free space to put.");
        }
    }
    public static int[] propStatic(int[] prop){
        int[] propStatic = new int[prop.length];
        for (int j : prop) {
            switch (j) {
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
                case 8:
                    propStatic[8]++;
            }
        }
        return propStatic;
    }
}


/*
    道具：
        1：回血烟
        2：刀
        3：药物
        4：手铐
        5：放大镜
        6：肾上腺素
        7：特殊手机
        8：逆转器
 */