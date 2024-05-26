package draft;

import homework.enhancedRandom;

public class Random6DigitNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.printf("%10d",enhancedRandom.getRandom(100000,1000000));
        }
    }
}

// 鸣潮幸运数字 361985
