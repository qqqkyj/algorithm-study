package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj14002 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken()); // 입력 수열
    }
    dp(arr); // LIS 계산 및 수열 출력
  }

  static void dp(int[] arr) {

    int[] d = new int[arr.length];    // d[i] : i번째 원소를 마지막으로 하는 LIS 길이
    int[] idx = new int[arr.length];  // idx[i] : i번째 원소 이전에 LIS를 끝내는 원소의 위치

    // LIS 길이 및 추적 배열 계산
    for (int i = 0; i < arr.length; i++) {
      d[i] = 1;  // 최소 길이는 자기 자신
      for (int j = i; j >= 0; j--) {  
        // 이전 원소가 현재 원소보다 작으면 LIS 연장 가능
        if (arr[j] < arr[i] && d[j] + 1 > d[i]) {
          d[i] = d[j] + 1; // LIS 길이 갱신
          idx[i] = j;      // 이전 위치 저장 (역추적용)
        }
      }
    }

    // 전체 LIS 길이와 마지막 원소 위치 찾기
    int max = 0;
    int max_idx = 0;
    for (int i = 0; i < arr.length; i++) {
      if (d[i] > max) {
        max = d[i];       // 최장 LIS 길이
        max_idx = i;      // LIS 끝 위치
      }
    }

    // 실제 LIS 수열 복원
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    sb.append(max).append("\n");  // LIS 길이 출력

    int cnt = max;
    while (cnt > 0) {
      stack.push(arr[max_idx]);     // 역순으로 스택에 저장
      max_idx = idx[max_idx];       // 이전 원소로 이동
      cnt--;
    }

    // 스택에서 꺼내면서 올바른 순서로 출력
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }

    System.out.print(sb);
  }
}