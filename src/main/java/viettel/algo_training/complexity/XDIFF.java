package main.java.viettel.algo_training.complexity;

import java.io.*;
import java.util.Arrays;

public class XDIFF {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine().trim());
    double[] a = new double[n];
    double maxDiff = Double.MIN_VALUE;
    double minElem = Double.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      a[i] = Double.parseDouble(br.readLine().trim());
    }

    for (int i = 0; i < n;i++) {
      if (a[i] < minElem) minElem = a[i];
      else {
        if (maxDiff < a[i] - minElem) {
          maxDiff = a[i] - minElem;
        }
      }
    }

    bw.write(String.valueOf(maxDiff));
    bw.flush();
  }
}
