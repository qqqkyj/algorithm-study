package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>(); // '(' 위치 저장
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i); // '(' 위치 스택에 저장
            } else {
                if (i - 1 == stack.peek()) { // 레이저 '()'인 경우
                    stack.pop();
                    sum += stack.size(); // 현재 스택 크기만큼 조각 추가
                } else { // 막대 끝 ')'인 경우
                    stack.pop();
                    sum += 1; // 막대 끝 조각 1개 추가
                }
            }
        }
        
        System.out.print(sum);
    }
}