package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11722 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.print(go(arr));
  }

  static int go(int[] arr) {
    int n = arr.length;
    // dp[i]: i번째 원소를 '시작'으로 하는 가장 긴 감소하는 부분 수열의 길이
    int[] dp = new int[n];

    // 1. 뒤에서부터 앞으로 이동하며 각 원소를 '시작점'으로 설정
    for (int i = n - 1; i >= 0; i--) {
      // 초기값: 자기 자신만 포함하는 수열의 길이는 1
      dp[i] = 1; 
      
      // 2. 현재 i번째 원소보다 오른쪽에 있는 원소(j)들을 확인
      for (int j = i + 1; j < n; j++) {
        // 3. 감소 조건: 현재 값(arr[i])이 오른쪽 값(arr[j])보다 커야 수열이 성립
        if (arr[i] > arr[j]) {
          // 4. 점화식: 기존 dp[i]와 (j에서 시작하는 감소 수열의 길이 + 현재 자기 자신) 중 최댓값 선택
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    // 5. 결과 추출: 모든 위치에서 시작하는 감소 수열 중 가장 긴 길이를 탐색
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}