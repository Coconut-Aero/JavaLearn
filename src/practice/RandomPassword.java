package practice;

import homework.enhancedRandom;
import homework.arrayTest;

import java.util.Scanner;

public class RandomPassword {
    // A Random Password Generator.
    static String[] Numbers = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0"};
    static String[] Capitals = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};
    static String[] Lowercases =  {"a", "b", "c", "d", "e", "f", "g",
            "h", "i" ,"j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z"};
    static String[] Symbols = {"!", "@", "#", "$", "%", "^", "&", "*",
            "(", ")", "_", "+", "-", "=", "[", "]",
            "{", "}", "|", ";", ":", "'", ",", ".",
            "<", ">", "/", "?"};
    static String[] AllSymbols = {
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0",
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g",
            "h", "i" ,"j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z",
            "!", "@", "#", "$", "%", "^", "&", "*",
            "(", ")", "_", "+", "-", "=", "[", "]",
            "{", "}", "|", ";", ":", "'", ",", ".",
            "<", ">", "/", "?"};
    static String[] NoSymbols = {
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0",
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g",
            "h", "i" ,"j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z"};


    public static String[][] GenerateRandomPassword() throws Exception {
        Scanner sc = new Scanner(System.in);
        String[][] Temp = new String[20][16];
        System.out.print("Enter the type of Password, 1 for 4*4, 2 for all random, 3 for all random but no symbols:");
        int PasswordType = sc.nextInt();
        return GeneratePassword(PasswordType, Temp);
    }

    public static String[][] GenerateRandomPasswordWithSpecialFormat(int Quantity, int Length) throws Exception {
        String[][] Temp = new String[Quantity][Length];
        return GeneratePassword(2, Temp);
    }

    public static String[][] GeneratePassword(int PasswordType , String[][] Password) throws Exception {
        if (PasswordType == 1) {
            for (int i = 0; i < Password.length; i++) {
                for (int k = 0; k < 4; k++) {
                    Password[i][k] = Numbers[enhancedRandom.getRandom(0, Numbers.length)];
                    Password[i][k+4] = Capitals[enhancedRandom.getRandom(0, Capitals.length)];
                    Password[i][k+8] = Lowercases[enhancedRandom.getRandom(0, Lowercases.length)];
                    Password[i][k+12] = Symbols[enhancedRandom.getRandom(0, Symbols.length)];
                }
            }
        }
        else if (PasswordType == 2) {
            for (int i = 0; i < Password.length; i++) {
                for (int k = 0; k < Password[i].length; k++) {
                    Password[i][k] = AllSymbols[enhancedRandom.getRandom(0, AllSymbols.length)];
                }
            }
        }
        else if (PasswordType == 3) {
            for (int i = 0; i < Password.length; i++) {
                for (int k = 0; k < Password[i].length; k++) {
                    Password[i][k] = NoSymbols[enhancedRandom.getRandom(0, NoSymbols.length)];
                }
            }
        }
        else {
            throw new Exception("RandomPassword.InvalidTypeError");
        }
        for (int i = 0; i < Password.length; i++) {
            for (int j = 0; j < enhancedRandom.getRandom(50,100); j++) {
                int q = enhancedRandom.getRandom(0, Password[i].length);
                int m = enhancedRandom.getRandom(0, Password[i].length);
                if (m==q){
                    j = -1;
                    continue;
                }
                String temp = Password[i][q];
                Password[i][q] = Password[i][m];
                Password[i][m] = temp;
            }
            arrayTest.printStringArrayNoSpace(Password[i],Password[i].length);
        }
        return Password;
    }
    //爱你
    //爱你
}