package algorithmdesign.dynamicprograming;

// f(n) == f(n-1) + f(n-2)
public class Fibonacci {
    static long iterFib(int n) {
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = f[2] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    static long curFib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return curFib(n - 1) + curFib(n - 2);
        }

    }

    static void main() {
        int n = 45;
        long startTime = System.nanoTime();
        long iterFibResult = iterFib(n);
        long endTime = System.nanoTime();
        System.out.println("iterFib(" + n + "): " + (endTime - startTime) / 1100_000.0 + "ms");
        System.out.println(iterFibResult);

        startTime = System.nanoTime();
        long curFibResult = curFib(n);
        endTime = System.nanoTime();
        System.out.println("curFib(" + n + "): " + (endTime - startTime) / 1100_000.0 + "ms");
        System.out.println(curFibResult);
    }
}
