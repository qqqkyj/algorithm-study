package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11055 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(go(n, arr));
  }

  static int go(int n, int[] arr) {
    // dp[i]: i번째 원소를 마지막으로 포함하는 '증가하는 부분 수열'의 최대 합
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      // 1. 초기값 설정: 일단 자기 자신(arr[i])만 수열에 포함된 상태로 시작
      dp[i] = arr[i]; 
      
      // 2. i 이전의 원소들을 탐색 (0 ~ i-1)
      for (int j = 0; j < i; j++) {
        // 3. 증가 조건 확인: 이전 원소(arr[j])가 현재 원소(arr[i])보다 작아야 함
        if (arr[j] < arr[i]) {
          // 4. 점화식: 기존 dp[i]와 'j번째까지의 최대 합 + 현재 값'을 비교하여 갱신
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
    }

    // 5. 결과 추출: 부분 수열이 반드시 마지막 원소에서 최대 합을 갖는 것은 아님
    // 따라서 dp 배열 전체를 순회하며 그중 가장 큰 값을 정답으로 채택
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}