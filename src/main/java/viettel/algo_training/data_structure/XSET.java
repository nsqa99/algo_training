package main.java.viettel.algo_training.data_structure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class XSET {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    Set<Integer> hset = new HashSet<>();
    for (int i = 0; i < t; i++) {
      hset.add(Integer.parseInt(br.readLine()));
    }
    bw.write(String.valueOf(hset.size()));
    bw.flush();
  }
}
