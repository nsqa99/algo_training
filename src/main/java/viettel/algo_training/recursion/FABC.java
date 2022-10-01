package main.java.viettel.algo_training.recursion;

import java.io.*;

public class FABC {
  static int n;
  static char[] rs;
  static Writer bw;

  static String strRs;

  static int minC;

  static int countC = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());

    minC = calculateMinC(n);

    rs = new char[n];

    step(0);

    System.out.println(strRs);

//    bw.write(strRs);

    bw.flush();
  }

  private static int calculateMinC(int n) {
    int minCVal = 0;
    int incr = 4;
    int prevFourCounter = 0;
    int fourCounter = 0;

    for (int i = 4; i <= n;) {
      if (incr == 3) {
        minCVal++;
        i += ++incr;

        continue;
      }

      if ((prevFourCounter == 0 || prevFourCounter == 2) && fourCounter == 3) {
        prevFourCounter = 3;
        fourCounter = 0;
        incr--;
      } else if (prevFourCounter == 3 && fourCounter == 2) {
        prevFourCounter = 2;
        fourCounter = 0;
        incr--;
      }

      minCVal++;
      fourCounter++;
      i += incr;
    }

    return minCVal;
  }

  private static void step(int pos) {
    if (strRs != null && !strRs.isBlank()) return;

    if (pos == n) {
      strRs = String.valueOf(rs);

      return;
    }

    for (char c = 'A'; c <= 'C'; c++) {
      if (pos == 0 || !existTwoCommonContiguousSubstrings(pos, c)) {
        if (c == 'C') {
          countC++;

          if (countC > minC) {
            break;
          }
        }
        rs[pos] = c;

        step(pos + 1);
      }
    }
  }

  private static boolean existTwoCommonContiguousSubstrings(int pos, char c) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < pos; i++) {
      stringBuilder.append(rs[i]);
    }
    stringBuilder.append(c);
    String tmpStr = stringBuilder.toString();
    int maxLen = tmpStr.length() / 2;

    for (int substringLen = 1; substringLen <= maxLen; substringLen++) {
      int start = tmpStr.length() - 1;
      int end = tmpStr.length() - substringLen;

      int count = 0;

      for (int i = start; i >= end; i--) {
        if (tmpStr.charAt(i) == tmpStr.charAt(i - substringLen)) {
          count++;
        }
      }

      if (count == substringLen) return true;
    }

    return false;
  }
}
