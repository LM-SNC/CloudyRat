package com.art.threads;

public class cls {
    public static void printCombinations(String str) {
        printCombinations(str, 0, str.length() - 1);
    }

    public static void printCombinations(String str, int k, int n) {
        if (k == n) {
            System.out.println(str);
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < str.length(); i += 2) {
                String stri = str.substring(i, i + 2);
                output.append((char) Integer.parseInt(stri, 16));
            }
            System.out.println(output);
        }
        else {
            for (int i = k; i < n; i++) {
                String tmp = modifyString(str, i, k);
                printCombinations(tmp, k + 1, n);
                modifyString(str, i, k);
            }
        }
    }

    public static String modifyString(String str, int x, int y) {

// for swapping characters inside a string
        char arr[] = str.toCharArray();
        char t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;

        String s = new String(arr);
        return s;
    }
}