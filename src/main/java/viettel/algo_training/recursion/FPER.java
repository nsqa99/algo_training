package main.java.viettel.algo_training.recursion;

import java.io.*;

public class FPER {
  static int n;
  static boolean[] isTaken;
  static int[] permutation;
  static Writer bw;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    isTaken = new boolean[n];
    permutation = new int[n];

    printPermutation(1, bw);

    bw.flush();
  }

  private static void printPermutation(int num, Writer bw) throws IOException {
    if (num > n) {
      for (int i=0;i<n;i++) {
        bw.write(permutation[i] + " ");
      }
      bw.write("\n");

      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!isTaken[i - 1]) {
        permutation[num - 1] = i;
        isTaken[i - 1] = true;

        printPermutation(num + 1, bw);

        isTaken[i - 1] = false;
      }
    }
  }
}
