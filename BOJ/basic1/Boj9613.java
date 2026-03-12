package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj9613 {
  public static void main(String[] args) throws Exception {
    // 입력을 빠르게 받기 위한 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 테스트 케이스 개수
    int cnt = Integer.parseInt(br.readLine());

    StringTokenizer st;

    // 테스트 케이스 만큼 반복
    for (int i = 0; i < cnt; i++) {

      // 한 줄에 여러 숫자가 들어오기 때문에 공백 기준으로 분리
      st = new StringTokenizer(br.readLine());

      // 첫 번째 값은 숫자의 개수
      int[] arr = new int[Integer.parseInt(st.nextToken())];

      // 배열에 숫자 저장
      for (int j = 0; j < arr.length; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      long sum = 0;

      // 모든 숫자 쌍의 조합을 만들기 위한 이중 반복문
      // (x,y) 쌍에서 x < y 형태로 중복 없이 탐색
      for (int x = 0; x < arr.length-1; x++) {
        for (int y = x+1; y < arr.length; y++) {

          // 두 수의 최대공약수(GCD)를 구해서 합에 누적
          sum += gcd(arr[x], arr[y]);
        }
      }

      // 각 테스트 케이스의 결과 출력
      System.out.println(sum);
    }
  }

  static int gcd(int x, int y) {

    // 두 수 중 큰 값을 left, 작은 값을 right에 저장
    int left = x > y ? x : y;
    int right = x < y ? x : y;

    // 유클리드 호제법
    // right가 0이 될 때까지 나머지 연산 반복
    while (right != 0) {
      int tmp = left % right; // 나머지
      left = right;           // 작은 값을 큰 값으로 이동
      right = tmp;            // 나머지를 작은 값으로
    }
    
    // 마지막 남은 값이 최대공약수
    return left;
  }
}