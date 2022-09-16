package main.java.viettel.algo_training.recursion;

import java.io.*;

public class FALALYZE {
  static int n;
  static Writer bw;

  static int[] analyzedNumbers;

  static int size;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    size = n;
    analyzedNumbers = new int[n];

//    analyze(1, n);

    analyzeInSecondWay(1, 1, n);

    bw.flush();
  }

  private static void analyze(int start, int total) throws IOException {
    if (total == 0) {
      int tmp = n;

      for (int i = 0; i < n; i++) {
        if (tmp - analyzedNumbers[i] >= 0) {
          bw.write(analyzedNumbers[i] + " ");

          tmp -= analyzedNumbers[i];
        }
      }

      bw.write("\n");
    }

    for (int i = 1; i <= total; i++) {
      if (total - i >= 0 && (start <= 1 || i >= analyzedNumbers[start - 2])) {
        analyzedNumbers[start - 1] = i;

        analyze(start + 1, total - i);
      }
    }
  }

  private static void analyzeInSecondWay(int start, int nextVal, int total) throws IOException {
    if (total == 0) {
      int tmp = n;

      for (int i = 0; i < n; i++) {
        if (tmp - analyzedNumbers[i] >= 0) {
          bw.write(analyzedNumbers[i] + " ");

          tmp -= analyzedNumbers[i];
        }
      }

      bw.write("\n");
    }

    for (int i = nextVal; i <= total; i++) {
      if (total - i >= 0) {
        analyzedNumbers[start - 1] = i;

        analyzeInSecondWay(start + 1, i, total - i);
      }
    }
  }
}
