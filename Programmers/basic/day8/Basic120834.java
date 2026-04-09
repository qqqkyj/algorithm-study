package day8;

import java.util.Stack;

public class Basic120834 {
  public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (age > 0) {
            //마지막 자리 수를 문자로 바꿔 stack에 저장
            stack.push((char)(age % 10 + 'a'));
            age = age/10;
        }
        
        while (!stack.isEmpty()) {
            //sb에 LIFO형식을 이용해 추가
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}
