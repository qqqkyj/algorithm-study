package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj17087 {
  public static void main(String[] args) throws Exception {

    // 빠른 입력을 위한 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫 줄 입력: 동생 수(n), 수빈 위치(s)
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());//동생의 수
    long s = Long.parseLong(st.nextToken()); //수빈이의 위치

    // 동생 위치 - 수빈 위치 차이를 저장할 배열
    long[] arr = new long[n];

    st = new StringTokenizer(br.readLine());

    // 각 동생과 수빈이의 "거리 차이" 계산
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken()) - s;
    }

    // D는 모든 거리 차이의 GCD
    long d = 0;

    // 동생이 한 명이면 그 거리 자체가 답
    if (arr.length == 1) {
      d = arr[0];
    }
    else {
      // 누적 GCD 계산
      // arr[i+1]에 gcd(arr[i], arr[i+1])을 계속 저장
      for (int i = 0; i < arr.length - 1; i++) {
        arr[i + 1] = gcd(arr[i], arr[i + 1]);
      }

      // 마지막 값이 전체 GCD
      // 거리이므로 음수일 경우 절대값 처리
      d = arr[arr.length-1] >= 0 ? arr[arr.length-1] : -arr[arr.length-1];
    }
    
    // 가능한 최대 이동 거리 D 출력
    System.out.print(d);
  }
  
  static long gcd(long x, long y) {

    // 두 수 중 큰 값 / 작은 값 설정
    long left = x > y ? x : y;
    long right = x < y ? x : y;

    // 유클리드 호제법
    // gcd(a,b) = gcd(b, a%b)
    while (right != 0) {
      long tmp = left % right;
      left = right;
      right = tmp;
    }

    // 마지막 남은 값이 최대공약수
    return left;
  }
}