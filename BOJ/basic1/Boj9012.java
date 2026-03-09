package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj9012 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String line;

    for (int i = 0; i < n; i++) {
      line = br.readLine();

      Stack<Character> stack = new Stack<>();
      boolean flag = true;
      for (char c : line.toCharArray()) {
        if (c == '(') {
          stack.push(c);
        } else {
          if (!stack.isEmpty()) {
            stack.pop();
          } else {// ')' 가 더 많을 때
            flag = false;
            break;
          }
        }
      }

      if (!stack.isEmpty()) //'('가 더 많을 때
        flag = false; 
      System.out.println(flag ? "YES" : "NO");
    }
  }
}
