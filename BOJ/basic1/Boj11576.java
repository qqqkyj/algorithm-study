package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11576 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken()); // 입력 숫자의 현재 진법 A
    int b = Integer.parseInt(st.nextToken()); // 변환할 목표 진법 B

    int m = Integer.parseInt(br.readLine()); // 입력 숫자의 자릿수 개수

    st = new StringTokenizer(br.readLine());

    int sum = 0;

    // A진법 → 10진수 변환
    // 자릿수를 왼쪽부터 읽으며 누적 계산
    // 공식: num = num * base + digit
    // 기존 값에 진법을 곱하면 자릿수가 한 칸 왼쪽으로 이동하고,
    // 여기에 현재 자리 숫자를 더해 실제 값을 구성
    // 예: 5 7 2 (base 10)
    // sum = 0*10 + 5 = 5
    // sum = 5*10 + 7 = 57
    // sum = 57*10 + 2 = 572
    for (int i = 0; i < m; i++) {
      int n = Integer.parseInt(st.nextToken());
      sum = sum * a + n; // 현재 값에 진법을 곱하고 다음 자리 숫자를 더함
    }
    
    // 10진수 → B진수 변환
    // 반복적으로 B로 나누면서 나머지를 구하면 각 자릿수가 생성됨
    // 나머지는 "낮은 자리 → 높은 자리" 순서로 생성되기 때문에
    // 역순 출력이 필요

    // Stack을 사용하면 LIFO 구조를 이용해 자연스럽게 역순 출력 가능
    Stack<Integer> stack = new Stack<>();

    // 예외 처리: 변환 값이 0인 경우
    if (sum == 0)
      stack.push(0);

    // 나머지를 스택에 저장 (낮은 자리부터 생성됨)
    while (sum > 0) {
      stack.push(sum % b); // 현재 자리 숫자
      sum = sum / b;       // 다음 자릿수 계산을 위해 몫으로 갱신
    }

    StringBuilder sb = new StringBuilder();

    // 스택에서 pop하면 높은 자리부터 출력됨
    // (Stack의 LIFO 특성 이용)
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }

    // 마지막 공백 제거 후 출력
    System.out.print(sb.substring(0, sb.length() - 1));
  }
}