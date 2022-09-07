package main.java.viettel.algo_training.data_structure;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class XSETDIFF {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] nm = br.readLine().split("\\s+");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[] a1 = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    int[] a2 = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    Map<Integer, Integer> tmap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      tmap.put(a1[i], 1);
    }
    for (int i = 0; i < m; i++) {
      if (tmap.containsKey(a2[i]) && tmap.get(a2[i]) == 1) {
        tmap.put(a2[i], tmap.getOrDefault(a2[i], 0) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : tmap.entrySet()) {
      int key = entry.getKey();
      int val = entry.getValue();
      if (val > 1) {
        bw.write(key + " ");
      }
    }
    bw.flush();
  }
}
