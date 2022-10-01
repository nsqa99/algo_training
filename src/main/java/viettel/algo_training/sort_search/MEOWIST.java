package main.java.viettel.algo_training.sort_search;

import java.io.*;
import java.util.*;

public class MEOWIST {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<NameAge> listData = new ArrayList<>();

    while (true) {
      String inp = br.readLine();
      if (inp == null || inp.isEmpty()) break;

      String[] nameAge = inp.split("\\s+");
      listData.add(new NameAge(nameAge[0], Integer.parseInt(nameAge[1])));
    }

    Collections.sort(listData);

    for (NameAge data : listData) {
      bw.write(data.getName() + "\n");
    }

    bw.flush();
  }
}

class NameAge implements Comparable<NameAge> {
  private String name;
  private int age;

  public NameAge(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public int compareTo(NameAge another) {
    if (age != another.getAge()) {
      return another.getAge() - age;
    } else {
      return name.compareTo(another.getName());
    }
  }
}
