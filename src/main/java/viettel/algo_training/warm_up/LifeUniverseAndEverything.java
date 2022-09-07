package main.java.viettel.algo_training.warm_up;

import java.io.*;

public class LifeUniverseAndEverything {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(true) {
      String num = br.readLine();
      if (num.equals("42")) break;
      bw.write(num + "\n");
    }
    bw.flush();
  }
}
