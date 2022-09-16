package main.java.viettel.algo_training.recursion;

import java.io.*;
import java.util.*;

public class XCKN {
  static int MOD = (int) (1e9 + 7);
  static Map<List<Integer>, Integer> combinationMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      int[] inp = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

      bw.write(combination(inp[0], inp[1]) + "\n");
    }
    bw.flush();
  }

  private static int combination(int k, int n) {
    List<Integer> combined = List.of(k, n);

    if (combinationMap.containsKey(combined)) {
      return combinationMap.get(combined);
    }

    if (k == n || k == 0) return 1;

    int nInclusive = combination(k - 1, n - 1);
    int nExclusive = combination(k, n - 1);

    int rs = (nInclusive + nExclusive) % MOD;
    combinationMap.put(combined, rs);

    return rs;
  }
}
