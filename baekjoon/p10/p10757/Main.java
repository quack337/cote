package baekjoon.p10.p10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a = reader.readLine().split(" +");
        BigInteger i1 = new BigInteger(a[0]);
        BigInteger i2 = new BigInteger(a[1]);
        System.out.println(i1.add(i2));
    }
}
