package baekjoon.b32028;

import java.io.*;
import java.util.*;

  public class Main {
    static int[][][] B;
    static int[] C;
    static int[] E = {0,-1};
    static String[] X;

    static boolean notEmpty(int d) {
      if (d >= C.length) return false;
      return C[d] > 0;
    }

    static int last(int d) {
      int i = C[d] - 1;
      return B[d][i][0];
    }

    static int[] pop(int d) {
      int i = --C[d];
      return B[d][i];
    }

    static boolean between(int val, int mn, int mx) {
      return mn <= val && val <= mx;
    }

    static void fail() {
      System.out.println(-1);
      System.exit(0);
    }

    static void BT(int d, int[] n, int mn, int mx) {
      int cd = d + 1; // child depth
      int[] l=E, r=E, t;
      if (notEmpty(cd) && between(last(cd),mn,mx)) {
        t = pop(cd);
        if(t[0]<n[0]){
          l=t;
          if(notEmpty(cd) && between(last(cd),mn,mx)) {
            r = pop(cd);
            if(r[0]<n[0])fail();
          }
        } else r = t;
      }
      X[n[1]-1] = l[1]+" "+r[1];
      if(l[1]>0)BT(cd,l,mn,n[0]);
      if(r[1]>0)BT(cd,r,n[0],mx);
    }

    public static void main(String[] args) throws IOException {
      var br = new BufferedReader(new InputStreamReader(System.in));
      var st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      var A = new int[N][]; 
      X = new String[N]; int depth = 0;
      for (int i=0; i<N; ++i){
        X[i] = "";
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        A[i] = new int[] {v, d};
        if (d>depth) depth=d;
      }
      C = new int[depth+1]; Arrays.fill(C,0);
      for (int i=0; i<N; ++i)
        C[A[i][1]]++;
      B = new int[depth+1][][];
      for (int d=1; d<=depth; ++d)
        B[d] = new int[C[d]][];
      int[] I = new int[depth+1];
      Arrays.fill(I, 0);
      for (int i=0;i<N;++i) {
        int v = A[i][0], d = A[i][1];
        B[d][I[d]] = new int[] {v, i+1};
        I[d]++;
      }
      for (int d=1; d<=depth; ++d)
        Arrays.sort(B[d], (a,b) -> Integer.compare(b[0],a[0]));
      if (C[1] != 1) fail();
      BT(1,pop(1),Integer.MIN_VALUE,Integer.MAX_VALUE);
      for(int i=1;i<=depth;++i)
        if(C[i]!=0)fail();
      System.out.println(String.join("\n", X));
    }
  }