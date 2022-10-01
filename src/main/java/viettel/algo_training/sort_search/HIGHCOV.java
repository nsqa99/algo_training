package main.java.viettel.algo_training.sort_search;

import java.io.*;
import java.util.Arrays;

public class HIGHCOV {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] mn = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    int m = mn[0], n = mn[1];
    int[] stations = new int[mn[1]];

    for (int i = 0; i < n; i++) {
      stations[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(stations);

    int maxVal = Integer.MIN_VALUE;
    for (int i = 0; i < n - 1; i++) {
      int diff = stations[i + 1] - stations[i];
      if (diff > maxVal) {
        maxVal = diff;
      }
    }

    bw.write(maxVal + "\n");
    bw.flush();
  }
}
