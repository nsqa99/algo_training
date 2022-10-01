package main.java.viettel.algo_training.sort_search;

import java.io.*;
import java.util.Arrays;

public class BSEARCH1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] nq = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    int n = nq[0], q = nq[1];
    int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

    while (q-- > 0) {
      bw.write(findNum(a, Integer.parseInt(br.readLine())) + "\n");
    }

    bw.flush();
  }

  private static int findNum(int[] a, int numToFind) {
    int low = 0;
    int high = a.length - 1;

    while (low < high) {
      int mid = low - (low - high) / 2;
      if (a[mid] < numToFind) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    if (a[low] == numToFind) return low;

    return -1;
  }
}
