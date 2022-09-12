package main.java.viettel.algo_training.complexity;

import java.io.*;
import java.util.Arrays;

public class THREESUM {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine().trim());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine().trim());
    }

    Arrays.sort(a);

    int count = 0;

    for (int k = 0; k < n - 2; k++) {
      int i = k + 1;
      int j = n - 1;
      while (i < j) {
        if (a[k] + a[i] + a[j] < 0) {
          i++;
        } else if (a[k] + a[i] + a[j] > 0) {
          j--;
        } else if (a[k] + a[i] + a[j] == 0) {
          count++;
          i++;
          j--;
        }
      }
    }

    bw.write(String.valueOf(count));
    bw.flush();
  }
}
