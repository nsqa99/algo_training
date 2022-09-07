package main.java.viettel.algo_training.warm_up;

import java.io.*;

public class FSWAP {
  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] nums = br.readLine().split("\\s+");
    long s1 = Long.parseLong(nums[0] + nums[1]);
    long s2 = Long.parseLong(nums[1] + nums[0]);
    bw.write(s1 > s2 ? String.valueOf(s1) : String.valueOf(s2));
    bw.flush();
  }
}
