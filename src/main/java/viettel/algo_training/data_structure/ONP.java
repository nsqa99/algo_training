package main.java.viettel.algo_training.data_structure;

import java.io.*;
import java.util.Map;
import java.util.Stack;

public class ONP {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    Map<Character, Integer> hmap = Map.of('(', 0, '+', 1, '-', 1, '*', 2, '/', 2, '^', 3);
    while (t-- > 0) {
      Stack<Character> st = new Stack<>();
      String expr = br.readLine();
      StringBuilder rs = new StringBuilder();
      for (int i = 0; i < expr.length(); i++) {
        Character elem = expr.charAt(i);
        if (elem != '(' && hmap.containsKey(elem)) {
          while (!st.empty() && (!hmap.containsKey(st.peek()) || hmap.get(st.peek()) >= hmap.get(elem))) {
            rs.append(st.pop());
          }
          st.push(elem);
        } else if (elem == ')') {
          while (!st.empty() && st.peek() != '(') {
            rs.append(st.pop());
          }
          if (!st.empty()) st.pop();
        } else {
          st.push(elem);
        }
      }
      while (!st.empty()) {
        rs.append(st.pop());
      }
      bw.write(rs + "\n");
    }
    bw.flush();
  }
}
