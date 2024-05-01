package homework;

public class enhancedRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 15; j++) {
                int res = getRandom(1,100,4,8,95,93);
                System.out.printf("%4d",res);
            }
            System.out.println();
        }
    }
    public static int getRandom(int start, int end, int... numbers) {
        int result;
        result = (int) (Math.random() * (end - start) + start);
        for (int i = 0; i < numbers.length; i++) {
            if (result == numbers[i]) {
                result = (int) (Math.random() * (end - start) + start);
                i=0;
            }
        }
        return result;
    }
}
