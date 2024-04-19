public class numberSingleDigit {
    public static void main(String[] args) {
        int[] tmp = new int[100];
        int[] count = new int[10];
        for (int i = 0; i < 100; i++) {
            tmp[i] = enhancedRandom.getRandom(-1,10,-1,10);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%5d", tmp[i*10+j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 100; i++) {
            switch (tmp[i]) {
                case 0:
                    count[0]++;
                    continue;
                case 1:
                    count[1]++;
                    continue;
                case 2:
                    count[2]++;
                    continue;
                case 3:
                    count[3]++;
                    continue;
                case 4:
                    count[4]++;
                    continue;
                case 5:
                    count[5]++;
                    continue;
                case 6:
                    count[6]++;
                    continue;
                case 7:
                    count[7]++;
                    continue;
                case 8:
                    count[8]++;
                    continue;
                case 9:
                    count[9]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Number " + i + " Appears " + count[i] + " times");
        }
    }
}
