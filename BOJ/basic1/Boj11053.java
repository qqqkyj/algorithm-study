package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11053 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine()); // 수열의 길이
    
    int[] arr = new int[n]; // 입력 수열
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken()); // 수열 값 입력
    }

    System.out.print(dp(arr)); // LIS 길이 계산
  }

  static int dp(int[] arr) {

    int[] d = new int[arr.length];

    // d[i] : i번째 원소를 마지막으로 하는
    // 가장 긴 증가하는 부분 수열(Longest Increasing Subsequence)의 길이

    for (int i = 0; i < arr.length; i++) {

      d[i] = 1;
      // 최소 길이 = 자기 자신 하나

      for (int j = i; j >= 0; j--) {

        // 이전 원소가 현재 원소보다 작다면
        // 증가하는 수열을 만들 수 있음
        if (arr[j] < arr[i])

          // j에서 끝나는 LIS 뒤에 arr[i]를 붙일 수 있음
          // 기존 값과 비교해서 더 큰 값으로 갱신
          d[i] = Math.max(d[j] + 1, d[i]);
      }
    }

    // 전체 LIS 길이 중 최대값
    int max = 0;
    for (int i = 0; i < d.length; i++) {
      max = Math.max(max, d[i]);
    }
    return max;
  }
}