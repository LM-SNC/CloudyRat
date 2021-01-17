package com.art.threads;

public class Main {

    public static void main(String[] args) {
        char c = '5';
        String bits = "";
        for (int i = 0; i < 8; ++i)
        {
            // extract the i-th bit
            int b = ((c & 1<<i) >> i);
            bits = bits + b;
            // b will be 1 if i-th bit is set, 0 otherwise

            // do whatever you want with b
        }
        Integer.toBinaryString(c);



    }
}
