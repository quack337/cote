package baekjoon.p03.p3954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static class Interpreter {
        byte[] A;
        int pointer;
        char[] cmd, input;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        public Interpreter(int Sm, char[] cmd, char[] input) {
            this.A = new byte[Sm];
            this.pointer = 0;
            this.cmd = cmd;
            this.input = input;
        }

        public void run() {
            for (char c : cmd) {
                switch (c) {
                case '-': A[pointer]--; break;
                case '+': A[pointer]++; break;
                case '<': --pointer; break;
                case '>': ++pointer; break;
                case '[':
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int Sm = Integer.parseInt(tokenizer.nextToken());
            int Sc = Integer.parseInt(tokenizer.nextToken());
            int Si = Integer.parseInt(tokenizer.nextToken());
            char[] cmd = reader.readLine().toCharArray();
            char[] input = reader.readLine().toCharArray();
        }


    }
}