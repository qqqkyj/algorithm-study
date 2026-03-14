package BOJ.basic1;

import java.io.*;

public class Boj11727 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.print(dp(n));
  }

  static int dp(int n) {
    // n이 1인 경우를 대비해 크기를 n + 1로 설정 (IndexOutOfBounds 방지)
    int[] arr = new int[n + 1];
    
    // 기본 사례(Base Case) 설정
    // n=1일 때: 2×1 타일 1개 (방법 1가지)
    arr[1] = 1;

    if (n >= 2)
      // n=2일 때: 2×1 2개, 1×2 2개, 2×2 1개 (방법 3가지)
      arr[2] = 3;

    // 점화식: f(i) = f(i-1) + f(i-2) * 2
    for (int i = 3; i <= n; i++) {
      /* * 1. 마지막에 2×1 타일을 붙이는 경우: f(i-1)
       * 2. 마지막에 1×2 타일 2개를 붙이는 경우: f(i-2)
       * 3. 마지막에 2×2 타일 1개를 붙이는 경우: f(i-2)
       * 즉, f(i-2) 상황에서 2가지 선택지가 추가되므로 f(i-2) * 2를 더함
       */
      arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
    }

    return arr[n];
  }
}