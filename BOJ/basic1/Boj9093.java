//채점할 때 package 지우고, 클래스 이름 반드시 Main으로 할 것
//시간 초과 발생으로 System.out.print 대신 StringBuilder 사용
package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj9093 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
    for (int i = 0; i < n; i++) {
      String line = br.readLine();

      for (char c : line.toCharArray()) {
        if (c == ' ') {
          while (!stack.isEmpty()) {
            sb.append(stack.pop());
          }
          sb.append(' ');
        } else {
          stack.push(c);
        }
      }
      // 마지막 단어 출력
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }

      sb.append('\n'); //줄바꿈
    }
    
    System.out.print(sb);
  }
}
