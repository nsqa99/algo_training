package main.java.viettel.algo_training.sort_search;

import java.io.*;
import java.util.Arrays;

public class FSORT {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();

    for (int i = 0; i < n; i++) {
      bw.write(a[i] + " ");
    }

    bw.newLine();
    bw.flush();
  }
}
