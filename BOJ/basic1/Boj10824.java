package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj10824 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 공백을 기준으로 입력값을 나누기 위해 StringTokenizer 사용
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    // 1. 첫 번째 수와 두 번째 수를 문자열 상태에서 결합(+)한 뒤 정수로 변환
    long num1 = Long.parseLong(st.nextToken() + st.nextToken());
    
    // 2. 세 번째 수와 네 번째 수를 문자열 상태에서 결합(+)한 뒤 정수로 변환
    long num2 = Long.parseLong(st.nextToken() + st.nextToken());
    
    // 3. 두 숫자의 합을 출력
    System.out.print(num1 + num2);
  }
}