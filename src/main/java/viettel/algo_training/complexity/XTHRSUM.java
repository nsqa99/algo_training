package main.java.viettel.algo_training.complexity;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class XTHRSUM {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/viettel/algo_training/tcs.txt")));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();

      List<String> rs = new ArrayList<>();
      for (int i = 0; i < n - 2; i++) {
        int j = i + 1;
        int k = n - 1;

        while (j < k) {
          if (a[i] + a[j] + a[k] < 0) {
            j++;
          } else if (a[i] + a[j] + a[k] > 0) {
            k--;
          } else if (a[i] + a[j] + a[k] == 0) {
            rs.add(a[i] + " " + a[j] + " " + a[k]);
            j++;
            k--;
          }
        }
      }

      rs = rs.stream().distinct().collect(Collectors.toList());

      bw.write(rs.size() + "\n");
      for (String data : rs) {
        bw.write(data + "\n");
      }
    }

    bw.flush();
  }
}
