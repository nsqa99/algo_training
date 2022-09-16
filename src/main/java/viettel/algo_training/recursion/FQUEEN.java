package main.java.viettel.algo_training.recursion;

import java.io.*;

public class FQUEEN {
  static int n;
  static boolean[] isUnderControl;
  static int[] queenPos;
  static Writer bw;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    isUnderControl = new boolean[n];
    queenPos = new int[n];

    placeQueen(1, bw);

    bw.flush();
  }

  private static void placeQueen(int row, Writer bw) throws IOException {
    if (row > n) {
      for (int i = 0; i < n; i++) {
        bw.write(queenPos[i] + " ");
      }
      bw.write("\n");

      return;
    }

    for (int col = 1; col <= n; col++) {
      if (!isUnderControl[col - 1] && isDiagonalFree(row, col)) {
        isUnderControl[col - 1] = true;
        queenPos[row - 1] = col;
        placeQueen(row + 1, bw);

        isUnderControl[col - 1] = false;
      }
    }
  }

  private static boolean isDiagonalFree(int row, int col) {
    int diff = row - col;
    int sum = row + col;

    for (int i = 1; i <= row - 1; i++) {
      if (((i - queenPos[i - 1]) == diff) || (i + queenPos[i - 1] == sum)) {
        return false;
      }
    }

    return true;
  }
}
