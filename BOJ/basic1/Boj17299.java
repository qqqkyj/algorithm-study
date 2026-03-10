package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj17299 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] origin = new int[n]; // 원래 수열
    int[] trans = new int[n];  // 등장 횟수 배열 → 나중에 NGF 결과 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();

    // 각 숫자의 등장 횟수 계산
    for (int i = 0; i < n; i++) {
      origin[i] = Integer.parseInt(st.nextToken());
      map.put(origin[i], map.getOrDefault(origin[i], 0)+1);
    }

    // 수열을 등장 횟수 배열로 변환
    for (int i = 0; i < n; i++) {
      trans[i] = map.get(origin[i]);
    }

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      // 오른쪽에 있으면서 등장 횟수가 더 큰 경우
        while (!stack.isEmpty() && trans[stack.peek()] < trans[i]) {
          trans[stack.pop()] = origin[i]; // 오등큰수 저장
        }
        stack.push(i); // 비교할 인덱스 저장
    }

    // 오등큰수가 없는 경우 -1
    while (!stack.isEmpty()) {
      trans[stack.pop()] = -1;
    }

    // 결과 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n - 1; i++) {
      sb.append(trans[i]).append(" ");
    }
    sb.append(trans[n - 1]);
    System.out.print(sb);

  }
}