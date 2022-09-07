package main.java.viettel.algo_training.data_structure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class XMAP {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      hmap.put(n, hmap.getOrDefault(n, 0) + 1);
    }
    int maxKey = Integer.MIN_VALUE;
    int maxValue = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
      int key = entry.getKey();
      int val = entry.getValue();
      if (val > maxValue) {
        maxValue = val;
        maxKey = key;
      } else if (val == maxValue && key > maxKey) {
        maxKey = key;
      }
    }
    bw.write(String.valueOf(maxKey));
    bw.flush();
  }
}
