package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj17298 {
  public static void main(String[] args) throws Exception {
    // 오큰수 : 오른쪽에 있으면서 자신보다 큰 수 중 가장 먼저 나오는 수
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken()); // 수열 입력
    }

    Stack<Integer> stack = new Stack<>(); // 오큰수를 찾지 못한 인덱스 저장
    for (int i = 0; i < arr.length; i++) {
      
      // 현재 값이 스택 top의 값보다 크면 오큰수 발견
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        arr[stack.pop()] = arr[i]; // pop한 인덱스의 오큰수를 현재 값으로 설정
      }
      
      stack.push(i); // 아직 오큰수를 못 찾은 인덱스 저장
    }
    
    // 끝까지 오큰수를 못 찾은 경우
    while (!stack.isEmpty()) {
      arr[stack.pop()] = -1;
    }
    
    // 출력 형식 맞추기
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length - 1; i++) {
      sb.append(arr[i]);
      sb.append(" ");
    }
    sb.append(arr[arr.length - 1]);
    
    System.out.print(sb);
  }
}