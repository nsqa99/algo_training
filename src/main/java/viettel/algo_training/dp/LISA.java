package main.java.viettel.algo_training.dp;

import java.io.*;
import java.util.Arrays;

public class LISA {
  static long[][] min;
  static long[][] max;

  static char[] expression;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int k = Integer.parseInt(br.readLine());
    while (k-- > 0) {
      expression = br.readLine().toCharArray();
      int n = expression.length;
      min = new long[n][n];
      max = new long[n][n];

      for (long[] row : min) {
        Arrays.fill(row, -1);
      }

      for (long[] row : max) {
        Arrays.fill(row, -1);
      }

      detectMinMax(0, n - 1);

      bw.write(max[0][n - 1] + " " + min[0][n - 1] + "\n");
    }

    bw.flush();
  }

  private static void detectMinMax(int start, int end) {
    if (min[start][end] != -1 && max[start][end] != -1) return;

    if (start == end) {
      min[start][end] = Long.parseLong(String.valueOf(expression[start]));
      max[start][end] = Long.parseLong(String.valueOf(expression[start]));

      return;
    }

    if (start + 2 == end) {
      min[start][end] = calc(Long.parseLong(String.valueOf(expression[start])),
          Long.parseLong(String.valueOf(expression[end])), expression[start + 1]);
      max[start][end] = min[start][end];

      return;
    }

    for (int i = start; i <= end - 2; i += 2) {
      detectMinMax(start, i);
      detectMinMax(i + 2, end);

      if (min[start][end] != -1) {
        min[start][end] = Math.min(min[start][end], calc(min[start][i], min[i + 2][end], expression[i + 1]));
      } else {
        min[start][end] = calc(min[start][i], min[i + 2][end], expression[i + 1]);
      }

      max[start][end] = Math.max(max[start][end], calc(max[start][i], max[i + 2][end], expression[i + 1]));
    }
  }

  private static long calc(long num1, long num2, char operator) {
    if (operator == '+') {
      return num1 + num2;
    }

    return num1 * num2;
  }
}
