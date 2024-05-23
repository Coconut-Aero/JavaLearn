package practice;

public class PrimeNumber {
    public static boolean isPrime(int n) {
        for (int i = 2; Math.pow(i,2) <= n; i++) { // 优化后的判断
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1; // 排除1不是质数的情况
    }
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            System.out.printf("%3s",stack.pop());
        }
    }
}

class StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
        size = 0; // 正确的初始化
    }

    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    public int pop() {
        return elements[--size];
    }

    public boolean empty() {
        return size == 0;
    }
}