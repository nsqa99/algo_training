package main.java.viettel.algo_training.data_structure;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class STPAR {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true) {
      int t = Integer.parseInt(br.readLine());
      if (t == 0) {
        break;
      }
      int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      Stack<Integer> st = new Stack<>();
      Stack<Integer> tmp = new Stack<>();
      LinkedList<Integer> q = new LinkedList<>();
      for (int i = 0; i < t; i++) {
        if (!q.isEmpty() && a[i] < q.peekLast()) {
          while (!q.isEmpty() && a[i] < q.peekLast()) {
            tmp.push(q.pollLast());
          }
          while (!tmp.empty()) {
            st.push(tmp.pop());
          }
        }
        while (!st.empty() && a[i] > st.peek()) {
          q.add(st.pop());
        }
        q.add(a[i]);
      }
      while (!st.empty()) {
        q.add(st.pop());
      }
      boolean isFalse = false;
      for (int i = 0; i < q.size() - 1; i++) {
        if (q.get(i) != i + 1) {
          isFalse = true;
          break;
        }
      }

      bw.write(isFalse ? "no\n" : "yes\n");
    }

    bw.flush();
  }
}
