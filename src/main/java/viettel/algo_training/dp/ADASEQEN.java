package main.java.viettel.algo_training.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ADASEQEN {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] nm = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    int n = nm[0];
    int m = nm[1];
    int[][] dp = new int[n + 1][m + 1];

    int[] price = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    char[] a = br.readLine().toCharArray();
    char[] b = br.readLine().toCharArray();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a[i - 1] == b[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + price[a[i - 1] - 'a'];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    System.out.println(dp[n][m]);
  }
}
