package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1935 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 사용되는 피연산자 개수 (A ~ ...)
    char[] arr = br.readLine().toCharArray(); // 후위표기식

    Map<Character, Double> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      // A, B, C ... 에 대응되는 실제 숫자 저장
      map.put((char) ('A' + i), Double.parseDouble(br.readLine()));
    }

    Stack<Double> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++){

      if (arr[i] == '*') { 
        // 스택에서 두 값 꺼내 곱셈 후 다시 push
        stack.push(stack.pop() * stack.pop());
      }

      else if (arr[i] =='/') {
        // 나눗셈은 순서 중요 (first / second)
        double second = stack.pop();
        double first = stack.pop();
        stack.push(first / second);
      }

      else if (arr[i] =='-') {
        // 뺄셈도 순서 중요 (first - second)
        double second = stack.pop();
        double first = stack.pop();
        stack.push(first - second);
      }

      else if (arr[i] =='+') {
        // 덧셈 후 push
        stack.push(stack.pop() + stack.pop());
      }

      else {
        // 피연산자(A,B,C...)이면 해당 숫자를 스택에 push
        stack.push(map.get(arr[i]));
      }
    }

    // 결과를 소수점 둘째자리까지 출력
    System.out.printf("%.2f",stack.peek());
  }
}