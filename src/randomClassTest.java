import java.security.SecureRandom;

public class randomClassTest {
    public static void main(String[] args) {
        byte[] seed = {10, 0, 0, 0};
        SecureRandom secureRandom = new SecureRandom(seed);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                int randomNumber = secureRandom.nextInt(101);
                System.out.printf("%5s",randomNumber);
            }
            System.out.println();
        }
    }
}
