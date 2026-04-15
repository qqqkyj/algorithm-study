import java.util.*;

public class Basic120894 {
    public long solution(String numbers) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();
        while(numbers.length() > 0){
            for(int i=0; i<arr.length; i++){
                if(numbers.startsWith(arr[i])){
                    sb.append(i);
                    numbers = numbers.substring(arr[i].length(), numbers.length());
                }
            }
        }
        return Long.parseLong(sb.toString());
    }
}