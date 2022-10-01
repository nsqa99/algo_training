package main.java.viettel.algo_training.dp;

import java.io.*;
import java.util.Arrays;

public class MIXTURES {
  static int[][] liquid;
  static long[][] smoke;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      String firstLine = br.readLine();
      if (firstLine == null || firstLine.isEmpty()) break;
      int n = Integer.parseInt(firstLine);
      liquid = new int[n + 1][n + 1];
      smoke = new long[n + 1][n + 1];
      int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

      for (int i = 1; i <= n; i++) {
        liquid[i][i] = a[i - 1];
      }

      mix(1, n);

      bw.write(smoke[1][n] + "\n");
    }

    bw.flush();
  }

  public static int mix(int start, int end) {
    if (start == end || smoke[start][end] > 0) return liquid[start][end];

    if (start + 1 == end) {
      smoke[start][end] = (long) liquid[start][start] * liquid[end][end];
      liquid[start][end] = (liquid[start][start] + liquid[end][end]) % 100;

      return liquid[start][end];
    }

    for (int i = start; i < end; i++) {
      int mixedLiquid1 = mix(start, i);
      int mixedLiquid2 = mix(i + 1, end);
      long newSmoke = (long) mixedLiquid1 * mixedLiquid2 + smoke[start][i] + smoke[i + 1][end];

      if (smoke[start][end] == 0) {
        smoke[start][end] = newSmoke;
        liquid[start][end] = (mixedLiquid1 + mixedLiquid2) % 100;
      } else if (smoke[start][end] > newSmoke) {
        smoke[start][end] = newSmoke;
        liquid[start][end] = (mixedLiquid1 + mixedLiquid2) % 100;
      }
    }

    return liquid[start][end];
  }
}
