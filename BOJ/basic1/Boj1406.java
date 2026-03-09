package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1406 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<String> leftStack = new Stack<>();
    Stack<String> rightStack = new Stack<>();
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    for (String c : br.readLine().split("")) {
      leftStack.push(c);
    }

    int n = Integer.parseInt(br.readLine());
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      String input = st.nextToken();

      //현재 커서 왼쪽에 추가
      if ("P".equals(input)) {
        leftStack.push(st.nextToken());
      }
      //커서를 왼쪽으로 옮김
      else if ("L".equals(input) && !leftStack.isEmpty()) {
        rightStack.push(leftStack.pop());
      }
      //커서를 오른쪽으로 옮김
      else if ("D".equals(input) && !rightStack.isEmpty()) {
        leftStack.push(rightStack.pop());
      }
      //현재 커서 왼쪽데이터 삭제(B)
      else if ("B".equals(input) && !leftStack.isEmpty()){
        leftStack.pop();
      }
    }

    while (!leftStack.isEmpty()) {
      rightStack.push(leftStack.pop());
    }

    while (!rightStack.isEmpty()) {
      sb.append(rightStack.pop());
    }

    System.out.print(sb);

  }
}
