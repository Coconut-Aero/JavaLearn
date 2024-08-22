package homework;

import java.security.SecureRandom;

public class enhancedRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 15; j++) {
                int res = getRandomExcept(1,100,4,8,95,93);
                System.out.printf("%4d",res);
            }
            System.out.println();
        }
    }
    public static int getRandomExcept(int start, int end, int... numbers) {
        if (start >= end) {
            throw new IllegalArgumentException("End must be greater than start");
        }
        int res;
        res = (int) (Math.random() * (end - start) + start);
        for (int i = 0; i < numbers.length; i++) {
            if (res == numbers[i]) {
                res = (int) (Math.random() * (end - start) + start);
                i=-1;
            }
        }
        return res;
    }
    public static int getRandom(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("End must be greater than start");
        }
        return (int) (Math.random() * (end - start) + start);
    }
    public static int getSecureRandom(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("End must be greater than start");
        }
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(end - start) + start;
    }

}
