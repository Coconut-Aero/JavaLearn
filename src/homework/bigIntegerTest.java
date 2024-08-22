package homework;

import java.math.BigInteger;

public class bigIntegerTest {
    public static void main(String[] args) {
        BigInteger a = new BigInteger(String.valueOf((long) Math.sqrt(Long.MAX_VALUE)-10));
        //BigInteger a = new BigInteger("3037000490");
        BigInteger b = new BigInteger("0");
        BigInteger max = new BigInteger(String.valueOf(Long.MAX_VALUE));
        while (b.compareTo(max) < 0) {
            b = a.multiply(a);
            a = a.add(BigInteger.ONE);
        }
        for (BigInteger i = a; i.compareTo(a.add(BigInteger.TEN)) < 0 ; i = i.add(BigInteger.ONE)) {
            b = i.multiply(i);
            System.out.println(b);
        }
    }
}
