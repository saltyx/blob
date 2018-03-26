package me.learn.topcoder;


import java.util.Arrays;

public class AB {

    private boolean success;
    public String createString(int N, int K) {
        char[] chars = new char[N];
        Arrays.fill(chars, 0, N, 'A');
        success = false;
        for (int i = 0; i < N; i++) {
            doIt(chars, 0, i, K);
            if (success)
                return new String(chars);
        }
        return "";
    }

    private void doIt(char[] ab,int start, int nB, int K) {
        if (success)
            return;
        if (nB < 0 || K <0 || start >= ab.length ||nB > ab.length-start)
            return;
        if (K == 0 && nB == ab.length-start) {
            success = true;
            Arrays.fill(ab, start, ab.length, 'B');
            return;
        }

        ab[start] = 'A';
        doIt(ab, start + 1, nB, K - nB);

        if (!success) {
            ab[start] = 'B';
            doIt(ab, start + 1, nB - 1, K);
        }
    }

    public static void main(String[] argv) {
        AB ab = new AB();
        System.out.println("result : " + ab.createString(3,2));
    }

}
