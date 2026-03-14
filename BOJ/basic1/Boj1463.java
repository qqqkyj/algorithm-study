package BOJ.basic1;

import java.io.*;

public class Boj1463 {
  public static void main(String[] args) throws Exception {

    // 입력을 빠르게 받기 위한 BufferedReader 사용
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 정수 n 입력
    int n = Integer.parseInt(br.readLine());

    // n을 1로 만드는 최소 연산 횟수 출력
    System.out.print(dp(n));
  }

  // n을 1로 만드는 최소 횟수를 구하는 DP 함수
  static int dp(int n) {

    // DP 배열
    // arr[i] : i를 1로 만들기 위한 최소 연산 횟수
    int[] arr = new int[n+1];

    // 1은 이미 1이므로 연산 횟수 0
    arr[1] = 0;

    // Bottom-Up 방식 DP
    // 작은 문제(2부터)부터 차례대로 해결
    for (int i = 2; i <= n; i++) {

      // ① 1을 빼는 경우
      // i → i-1 → ... → 1
      // 이전 값에 +1 연산
      arr[i] = arr[i - 1] + 1;

      // ② 2로 나누어지는 경우
      // i → i/2
      // 기존 값과 비교해서 더 작은 연산 횟수를 선택
      if(i % 2 == 0) arr[i] = arr[i] > arr[i / 2] + 1 ? arr[i / 2] + 1 : arr[i];

      // ③ 3으로 나누어지는 경우
      // i → i/3
      // 기존 값과 비교하여 최소값 선택
      if(i % 3 == 0) arr[i] = arr[i] > arr[i/3] + 1 ? arr[i/3] + 1 : arr[i];
    }

    // n을 1로 만드는 최소 연산 횟수 반환
    return arr[n];
  }
}