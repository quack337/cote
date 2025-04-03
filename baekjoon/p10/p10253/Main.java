package baekjoon.p10.p10253;

import java.util.Scanner;

public class Main {
    static class Fraction {
        int 분자, 분모;

        public Fraction(int 분자, int 분모) {
            this.분자 = 분자;
            this.분모 = 분모;
        }
        
        static Fraction 뺄셈(Fraction 분수1, Fraction 분수2) {
            long 분자 = 분수1.분자 * 분수2.분모 - 분수2.분자 * 분수1.분모;
            long 분모 = 분수1.분모 * 분수2.분모; 
            long 최대공약수 = 최대공약수(분자, 분모);
            return new Fraction((int)(분자/최대공약수), (int)(분모/최대공약수));
        }
        
        static long 최대공약수(long a, long b){
            while (b != 0) {
                long t = a % b;
                a = b;
                b = t;
            }
            return a;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (!(obj instanceof Fraction)) return false;
            Fraction f = (Fraction) obj;
            return 분모 == f.분모 && 분자 == f.분자;
        }
    }
    
    static int 올림_나눗셈(int a, int b) {
        return (a + b - 1) / b;
    }
    
    static Fraction 첫번째_단위분수(Fraction 분수) {        
        return new Fraction(1, 올림_나눗셈(분수.분모, 분수.분자));
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int 분자 = scanner.nextInt();
                int 분모 = scanner.nextInt();
                Fraction 분수 = new Fraction(분자, 분모);
                while (true) {
                    Fraction 첫번째_단위분수 = 첫번째_단위분수(분수);
                    if (첫번째_단위분수.equals(분수)) {
                        System.out.println(분수.분모);
                        break;
                    }                  
                    분수 = Fraction.뺄셈(분수, 첫번째_단위분수);
                }
            }
        }
        
    }
}