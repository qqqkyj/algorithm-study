package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1874 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int target = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n; i++) {
      stack.push(i);
      sb.append("+\n");
      //stack 상단(top)의 데이터가 target과 같을 동안 반복해서 pop
      while (!stack.isEmpty() && stack.peek() == target) {
        stack.pop();
        sb.append("-\n");

        String line = br.readLine();
        if (line == null || line.isEmpty()) // 더 이상 읽을 target이 없으면 반복 종료
          break;
        target = Integer.parseInt(line); // 다음 target으로 갱신
      }
    }

    // 모든 데이터를 pop해서 스택이 비어 있으면 연산 결과(sb) 출력
    // 스택이 비어있지 않으면 수열을 만들 수 없는 경우이므로 "NO" 출력
    System.out.print(stack.isEmpty() ? sb : "NO");
  }
}
