package homework;

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
        return (int) (Math.random() * (end - start) + start);
    }
}
