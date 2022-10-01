package main.java.viettel.algo_training.dp;

import java.io.*;
import java.util.Arrays;

public class XSTOCK {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int dayNums = Integer.parseInt(br.readLine());
      int[] price = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      int[] money = new int[dayNums + 1];

      money[0] = 0;
      money[1] = -price[0];

      for (int day = 2; day <= dayNums; day++) {
        for (int stockAmount = 0; stockAmount <= day; stockAmount++) {
          int prevDayAmount = stockAmount > 0 ? 1 : 0;
          money[stockAmount] = money[prevDayAmount] + price[day - 1] * (prevDayAmount - stockAmount);

          for (; prevDayAmount <= day - 1; prevDayAmount++) {
            money[stockAmount] = Math.max(money[stockAmount],
                money[prevDayAmount] + price[day - 1] * (prevDayAmount - stockAmount));
          }
        }
      }

      bw.write(money[0] + "\n");
    }
    bw.flush();
  }
}
