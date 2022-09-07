package main.java.viettel.algo_training.warm_up;

import java.io.*;
import java.util.Arrays;

public class FDEC {
  static int constraint = 1000000;
  static boolean[] isPrime = new boolean[constraint];

  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String msg = br.readLine();
    genPrimes();
    StringBuilder rs = new StringBuilder();
    for (int i=1;i<=msg.length();i++) {
      if (isPrime[i]) {
        rs.append(msg.charAt(i - 1));
      }
    }

    bw.write(rs + "\n");
    bw.flush();
  }

  public static void genPrimes() {
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i=2;i<constraint; i++) {
      if (isPrime[i]) {
        for (long j = (long) i *i; j<constraint; j+=i) {
          isPrime[(int) j] = false;
        }
      }
    }
  }
}
