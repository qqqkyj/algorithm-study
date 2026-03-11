package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj2004 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 조합 공식: nCr = n! / (r! * (n-r)!)
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    // 입력값이 최대 20억이므로 long 타입을 사용하여 오버플로우 방지
    long n = Long.parseLong(st.nextToken());
    long r = Long.parseLong(st.nextToken());
    
    // 1. 조합 공식에 따라 각 팩토리얼(n!, r!, (n-r)!)에 포함된 소인수 5의 개수를 계산
    // 지수 법칙에 의해 분자의 개수에서 분모의 개수들을 뺌 (count5 = n!의 5개수 - r!의 5개수 - (n-r)!의 5개수)
    long count5 = getCount(n, 5) - getCount(r, 5) - getCount(n - r, 5);
    
    // 2. 동일한 원리로 소인수 2의 개수를 계산
    // 팩토리얼 0의 개수 문제와 달리, 조합에서는 분모에서 2가 많이 나누어질 수 있어 2의 개수도 반드시 체크해야 함
    long count2 = getCount(n, 2) - getCount(r, 2) - getCount(n - r, 2);
    
    // 3. 10(0의 개수)은 2와 5가 한 쌍이 되어야 만들어지므로, 둘 중 더 적은 개수가 최종 0의 개수가 됨
    System.out.print(count5 < count2 ? count5 : count2);
  }

  /**
   * n! 이하의 자연수들 중에서 소인수 k가 총 몇 번 곱해졌는지 구하는 메서드
   * n을 k, k^2, k^3... 으로 나눈 몫을 합산하는 방식 (시간 복잡도: O(log n))
   */
  static long getCount(long n, int k) {
    long cnt = 0;
    while (n >= k) {
      cnt += n / k; // k의 배수, k^2의 배수... 등의 개수를 누적
      n = n / k;    // 다음 차수(k의 거듭제곱)를 계산하기 위해 n을 k로 나눔
    }
    return cnt;
  } 
}