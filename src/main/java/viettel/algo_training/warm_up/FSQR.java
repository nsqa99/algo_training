package main.java.viettel.algo_training.warm_up;

import java.io.*;

public class FSQR {
  public static void main(String[] args) throws IOException {
    //    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    long a, b;
    if (n <= 0) {
      a = -1;
      b = n == 0 ? 1 : 0;
    } else {
      int sqr = (int) Math.sqrt(n * 1.0);
      if (n == sqr* sqr) {
        a = (long) (sqr - 1) * (sqr-1);
        b = (long) (sqr + 1) * (sqr+1);
      } else {
        int tmpLower = (int) Math.floor(Math.sqrt(n * 1.0));
        a = (long) tmpLower * tmpLower;
        int tmpUpper = (int) Math.ceil(Math.sqrt(n * 1.0));
        b = (long) tmpUpper * tmpUpper;
      }
    }

    bw.write(a + " " + b + "\n");
    bw.flush();
  }
}
