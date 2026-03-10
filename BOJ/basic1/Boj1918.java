package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1918 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] arr = br.readLine().toCharArray();

    Queue<Character> charQueue = new LinkedList<>(); // 후위표기식 결과 저장
    Stack<Character> calStack = new Stack<>(); // 연산자 스택

    for (int i = 0; i < arr.length; i++) {

      if (arr[i] == ')') { 
        // '(' 나올 때까지 연산자 출력
        while (calStack.peek() != '(') {
          charQueue.offer(calStack.pop());
        }
        calStack.pop(); // '(' 제거
      } 

      else if (isAlphabet(arr[i])) { 
        // 피연산자(A~Z)는 바로 출력
        charQueue.offer(arr[i]);
      } 

      else {
        if (arr[i] == '(') {
          calStack.push(arr[i]); // '('는 스택에 저장
        } 

        else {
          // 스택 top 연산자의 우선순위가 더 높거나 같으면 먼저 출력
          while (!calStack.isEmpty()
                && priority(calStack.peek()) >= priority(arr[i])
                && calStack.peek() != '(') {
              charQueue.offer(calStack.pop());
            }
            calStack.push(arr[i]); // 현재 연산자 push
        }
      }
    }
    
    // 남아있는 연산자 모두 출력
    while (!calStack.isEmpty()) {
      charQueue.offer(calStack.pop());
    }

    // Queue → 문자열 변환
    StringBuilder sb = new StringBuilder();
    while (!charQueue.isEmpty()) {
      sb.append(charQueue.poll());
    }

    System.out.print(sb);
  }

  static boolean isAlphabet(char c) {
    boolean flag = false;
    for (int i = 0; i < 26; i++) {
      if (c == 'A' + i) {
        flag = true;
        break;
      }
    }
    return flag;
  }

  // 연산자 우선순위 반환
  static int priority(char c) {
    if (c == '*' || c == '/')
      return 2; // 높은 우선순위
    if (c == '+' || c == '-')
      return 1; // 낮은 우선순위
    return 0;
  }
}