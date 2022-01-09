package AlgorithmicToolBox.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        return major(a, left, right - 1);
    }

    private static int major(int[] a, int low, int high) {

        if (low == high) return a[low];
        int mid = (high - low) / 2 + low;
        int left_major = major(a, low, mid);
        int right_major = major(a, mid + 1, high);

        if (left_major == right_major) return left_major;

        int left_count = 0;
        int right_count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == left_major) left_count++;
            if (a[i] == right_major) right_count++;
        }

        if (left_count > a.length / 2) {
            return left_major;
        } else if (right_count > a.length / 2) {
            return right_major;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
