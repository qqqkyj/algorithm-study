package BOJ.basic1;

import java.io.*;

public class Boj11726 {
  public static void main(String[] args) throws Exception {

    // 입력을 빠르게 받기 위한 BufferedReader 사용
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 2 × n 타일의 n 입력
    int n = Integer.parseInt(br.readLine());

    // 2 × n 타일을 채우는 방법의 수 출력
    System.out.print(dp(n));
  }

  // 2 × n 타일을 채우는 방법의 수를 구하는 DP 함수
  static int dp(int n) {

    // DP 배열
    // arr[i] : 2 × i 크기의 타일을 채우는 방법의 수
    int[] arr = new int[n + 1];

    // 기본값 (Base Case)

    // 2 × 1 타일을 채우는 방법
    // 세로 타일 1개
    arr[1] = 1;

    // 2 × 2 타일을 채우는 방법
    // 1) 세로 + 세로
    // 2) 가로 + 가로
    if(n >= 2) arr[2]=2;

    // Bottom-Up 방식 DP
    // 작은 문제부터 차례대로 계산
    for (int i = 3; i <= n; i++) {

      // 마지막에 들어오는 블록 기준으로 경우를 나눔

      // ① 마지막이 세로 타일인 경우
      // 이전 상태는 2 × (i-1)
      // → arr[i-1]

      // ② 마지막이 가로 타일 2개인 경우
      // 이전 상태는 2 × (i-2)
      // → arr[i-2]

      // 두 경우를 더하면 전체 경우의 수
      arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
    }
      
    return arr[n];
  }
}