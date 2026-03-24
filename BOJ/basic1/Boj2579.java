package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj2579 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine()); // 계단 개수 입력
    
    int[] arr = new int[n+1]; // 1번부터 사용하기 위해 n+1 크기 배열 생성
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine()); // 각 계단의 점수 입력
    }
    
    System.out.println(go(arr)); // 최대 점수 계산 후 출력
  }

  static int go(int[] arr) {
    int[] dp = new int[arr.length]; // dp[i]: i번째 계단까지 왔을 때 얻을 수 있는 최대 점수

    // 핵심 규칙: 연속 3칸 밟기 금지
    // 가능한 경우 2가지
    // 1) i-2 → i (한 번에 두 칸 이동)
    //    dp[i] = dp[i-2] + arr[i]
    // 2) i-3 → i-1 → i (한 칸 + 한 칸, 단 i-2는 안 밟음)
    //    dp[i] = dp[i-3] + arr[i-1] + arr[i]

    dp[1] = arr[1]; // 첫 번째 계단은 무조건 밟음
    if(dp.length > 2) dp[2] = arr[1] + arr[2]; // 두 번째 계단은 1번 + 2번 밟는 것이 최대

    for (int i = 3; i < dp.length; i++) {
      // 두 경우 중 최대값 선택
      dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
      // (i-3 → i-1 → i) vs (i-2 → i)
    }

    return dp[dp.length-1]; // 마지막 계단까지의 최대 점수 반환
  }
}