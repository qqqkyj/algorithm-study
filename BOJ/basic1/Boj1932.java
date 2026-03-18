package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1932 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j <= i; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.print(go(arr));
  }

  static int go(int[][] arr) {
    int n = arr.length;
    // dp[i][j]: i행 j열까지 내려왔을 때 얻을 수 있는 최대 합
    int[][] dp = new int[n][n];

    // [초기값] 삼각형의 꼭대기 지점 설정
    dp[0][0] = arr[0][0];

    // 2행(인덱스 1)부터 바닥까지 아래로 내려가며 DP 테이블 채우기
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        // Case 1: 왼쪽 끝 지점 (바로 위에서만 내려올 수 있음)
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + arr[i][j];
        } 
        // Case 2: 오른쪽 끝 지점 (왼쪽 위에서만 내려올 수 있음)
        else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
        } 
        // Case 3: 가운데 지점 (왼쪽 위와 오른쪽 위 중 더 큰 값을 선택)
        else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
        }
      }
    }

    // [결과 추출] 삼각형의 마지막 줄(바닥)에 쌓인 값들 중 최댓값을 탐색
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[n - 1][i]);
    }
    
    return max;
  }
}