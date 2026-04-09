package day2;

import java.util.Arrays;

public class Basic120833 {
    public int[] solution(int[] numbers, int num1, int num2) {
        //numbers 배열의 num1부터 num2+1까지 복사
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }
}
