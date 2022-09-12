package main.java.viettel.algo_training.complexity;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSUMQ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    int t = Integer.parseInt(br.readLine());
    List<int[]> queries = new ArrayList<>();

    while(t-- > 0) {
      queries.add(Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray());
    }

    int[] cumulative = new int[n];
    cumulative[0] = a[0];

    for (int i=1;i<n;i++) {
      cumulative[i] = cumulative[i-1] + a[i];
    }

    for (int[] query : queries) {
      int i = query[0];
      int j = query[1];
      if (i == j) {
        bw.write(a[i] + "\n");
      } else if (i < 1) {
        bw.write(cumulative[j] + "\n");
      } else {
        bw.write(cumulative[j] - cumulative[i - 1] + "\n");
      }
    }

    bw.flush();
  }
}
