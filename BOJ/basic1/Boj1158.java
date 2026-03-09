package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1158 {
  public static void main(String[] args) throws Exception {
    // 입력을 빠르게 받기 위한 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 한 줄 읽어서 공백 기준으로 나눔
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 사람 수 n, 제거 순서 k
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    // 결과를 저장할 StringBuilder
    StringBuilder sb = new StringBuilder();
    sb.append("<"); // 요세푸스 순열 시작 기호

    // 1~n까지의 사람 번호를 큐에 넣음
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }

    // 큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      // k-1번 반복하면서 앞의 사람을 뒤로 이동
      for (int i = 0; i < k - 1; i++) {
        queue.add(queue.poll()); // 맨 앞 사람을 꺼내서 뒤로 넣음
      }
      // k번째 사람 제거 및 출력
      sb.append(queue.poll());
      // 큐가 비지 않았다면 쉼표 추가
      if(!queue.isEmpty()) sb.append(", ");
    }

    sb.append(">"); // 요세푸스 순열 끝 기호

    // 결과 출력
    System.out.print(sb);
  }
}