package main.java.viettel.algo_training.data_structure;

import java.io.*;
import java.util.Map;
import java.util.Stack;

public class BALBRACK {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Map<Character, Character> hmap = Map.of(')', '(', '}', '{', ']', '[');
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      Stack<Character> st = new Stack<>();
      String brk = br.readLine();
      for (int i=0;i<brk.length();i++) {
        char bracket = brk.charAt(i);

        if (bracket == ')' || bracket == '}' || bracket == ']') {
          while (!st.empty() && st.peek() != hmap.get(bracket)) {
            st.pop();
          }

          if (!st.empty()) {
            st.pop();
          } else {
            st.push(bracket);
          }
        } else {
          st.push(bracket);
        }
      }

      if (st.empty()) {
        bw.write("YES\n");
      } else {
        bw.write("NO\n");
      }
    }
    bw.flush();
  }
}
